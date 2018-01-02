import os

os.system("python3 pdfDownloader.py")
fileArray = os.listdir('inputFiles')
print (fileArray)

for file in fileArray:
    if ".pdf" in file:
        os.system("python3 pdf2txt.py inputFiles/" + file + " -o txtFiles/" + file.split(".")[0] + ".txt")
        print(file + " is converted to txt!")

fileArray = os.listdir('txtFiles')
print(fileArray)

for file in fileArray:
    if ".txt" in file:
        os.system("python3 prep.py txtFiles/" + file)
        print(file + " is prepproccesed!")
        os.system("python3 wordcloud.py --text" + file)

os.system("python3 term_counter.py")
