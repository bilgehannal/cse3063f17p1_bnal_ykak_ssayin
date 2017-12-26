
# !/usr/bin/env python

from collections import Counter
from operator import itemgetter
from math import log10
import os

string = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Bilgehan NAL what are you doing Bilgehan Bilgehan NAL a c b cv e rt y d a a a a a a"
string2 = " NAL NAL 2 3 4"

string_list = [string, string2]

# counting the words in a string and save in a dictionary
def count_words(string_list):
    dictionary_list = []
    for string in string_list:
        dictionary_list.append(Counter(string.split()))
    return dictionary_list

# dictionary which has counted values to list of tuple
def dictionary_to_tuple_list(dictionary_list):
    counted_words_list = []
    for dictionary in dictionary_list:
        counted_words_list.append(list(dictionary.items()))
    return counted_words_list

# sort the list according to the counted value in tuple
def get_sorted_tf(counted_words_list):
    sorted_words_list = []
    for counted_words in counted_words_list:
        # [::-1] -> converting to desc
        sorted_words_list.append(sorted(counted_words, key = lambda tup: tup[1])[::-1])
    return sorted_words_list

def calculate_inverse_document_frequency_for_word(word, string_list):
    counter_of_term = 0
    for string in string_list:
        if word in string:
            counter_of_term += 1
    return log10( len(string_list) / float(counter_of_term) )

def update_inverse_document_frequency(sorted_term_frequency_list, string_list):
    updated_idf_list = []
    for sorted_tf in sorted_term_frequency_list:
        temp_tuple_list = []
        for tuple_tf in sorted_tf:
            tmp_tuple = list(tuple_tf)
            tmp_tuple[1] *= calculate_inverse_document_frequency_for_word(tmp_tuple[0], string_list)
            temp_tuple_list.append(tuple(tmp_tuple))
        updated_idf_list.append(temp_tuple_list)
    return updated_idf_list

def get_sorted_tf_idf(calculated_idf_list):
    sorted_words_list = []
    for calculated_words in calculated_idf_list:
        sorted_words_list.append(sorted(calculated_words, key = lambda tup: tup[1])[::-1])
    return sorted_words_list

def calculate_tf(string_list):
    dictionary = count_words(string_list)
    tuple_mode_of_dictionary = dictionary_to_tuple_list(dictionary)
    sorted_tf = get_sorted_tf(tuple_mode_of_dictionary)
    return sorted_tf

def calculate_tf_idf(string_list):
    tf = calculate_tf(string_list)
    calculated_idf_list = update_inverse_document_frequency(tf, string_list)
    sorted_tf_idf = get_sorted_tf_idf(calculated_idf_list)
    return sorted_tf_idf

def write_tf_to_file(filename, tf_list):
    if os.path.exists(filename):
        os.remove(filename)
    with open(filename, 'a') as file:
        limit = 50
        if(len(tf_list) < 50):
            limit = len(tf_list)
        for index in range(limit):
            tf_tuple = tf_list[index]
            string = str(tf_tuple[0]) + ";" + str(tf_tuple[1])
            if(not tf_tuple[0] == tf_list[len(tf_list)-1][0]):
                string += "\n"
            file.write(string)
        

write_tf_to_file("wordcloud.py/words.csv",calculate_tf(string_list)[0])
print(calculate_tf(string_list))
print( "" )
print(calculate_tf_idf(string_list))
