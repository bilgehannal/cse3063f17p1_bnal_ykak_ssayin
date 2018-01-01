
#http://mimoza.marmara.edu.tr/~omer.korcak/

from bs4 import BeautifulSoup
import urllib.request
import requests
import os


with urllib.request.urlopen('http://mimoza.marmara.edu.tr/~omer.korcak/') as response:
   html_doc = response.read()


def download_file(url):
    local_filename = url.split('/')[-1]
    # NOTE the stream=True parameter
    r = requests.get(url, stream=True)
    with open(local_filename, 'wb') as f:
        for chunk in r.iter_content(chunk_size=1024): 
            if chunk: # filter out keep-alive new chunks
                f.write(chunk)
                #f.flush() commented by recommendation from J.F.Sebastian
    return local_filename


base_url = 'http://mimoza.marmara.edu.tr/~omer.korcak/'
soup = BeautifulSoup(html_doc, 'html.parser')

list = []

for html in soup.find_all('a'):
     length = len(html.get('href'))
     if html.get('href')[length-3:length].lower() == "pdf":
     	list.append(base_url + html.get('href'))

for a in list:
	print(a)
	download_file(a)

os.system("mv *.pdf inputFiles/")