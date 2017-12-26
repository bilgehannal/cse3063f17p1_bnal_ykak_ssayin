import io
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import string
#word_tokenize accepts a string as an input, not a file.
stop_words = stopwords.words('english')
stop_words.extend(["cafer","Ömer"])
file1 = open("output.txt")
line = file1.read()# Use this to read file content as a stream:
words = line.split()

print(stop_words)
for r in words:
	r = r.lower()
for r in words:

    if not r in stop_words:
        appendFile = open('zuzu.txt','a')
        appendFile.write(" "+r)
        appendFile.close()