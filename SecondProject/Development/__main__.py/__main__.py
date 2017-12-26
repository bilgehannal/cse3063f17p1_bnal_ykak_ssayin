import sys
import os
#import pdfDownloader
import pdf2txt


fileArray = os.listdir()

for file in fileArray:
    if ".pdf" in file:
        os.system("python3 pdf2txt.py " + file + " -o output" + file + ".txt")
        os.system("python3 prep.py output" + file + ".txt")
        
        os.system("python3 wordcloud.py")
