import io
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import string
import sys
import term_counter

#word_tokenize accepts a string as an input, not a file.
stop_words = stopwords.words('english')
stop_words.extend(["cafer","Ömer"])
file1 = open(sys.argv[1])
line = file1.read()# Use this to read file content as a stream:
words = line.split()

wholeString = ""

for r in words:
    r = r.lower()
    if not r in stop_words:
        appendFile = open(sys.argv[1] + 'prep.txt','a')
        r = r.lower()
        wholeString += r
        appendFile.write(" "+r)
        appendFile.close()

print(wholeString)