import subprocess
import os
from urllib.parse import urlencode
from urllib.request import Request, urlopen
from urllib.parse import urlencode
from urllib.request import Request, urlopen
#

url = 'http://api.reimaginebanking.com/accounts/5883e3351756fc834d8ebe89/purchases?key=b84d3a153e2842b8465bcc4fde3d1839' # Set destination URL here
post_fields = {'merchant_id': '57cf75cea73e494d8675ec49','medium':'balance','purchase_date':'2017-01-22','amount':'1','description':'string'}     # Set POST fields here

request = Request(url, urlencode(post_fields).encode())
request.header = {"Content-Type","application/json"}
json = urlopen(request).read().decode()
print(json)

#import serial
#ser = serial.Serial('.dev/tty/ACM1/9600')
if 1:
    #ser.readLine()
    #subprocess.call(["""curl -X POST --header "Content-Type: application/json" --header "Accept: application/json" -d "{\"merchant_id\": \"57cf75cea73e494d8675ec49\",\"medium\": \"balance\",\"purchase_date\": \"2017-01-22\",\"amount\": 1,\"description\": \"string\"}" "http://api.reimaginebanking.com/accounts/5883e3351756fc834d8ebe89/purchases?key=b84d3a153e2842b8465bcc4fde3d1839""",shell = True])
    #subprocess.call(["exit 1"])
    print("starting")
    os.system('curl -X POST --header "Content-Type: application/json" --header "Accept: application/json" -d "{\"merchant_id\": \"57cf75cea73e494d8675ec49\",\"medium\": \"balance\",\"purchase_date\": \"2017-01-22\",\"amount\": 1,\"description\": \"string\"}" "http://api.reimaginebanking.com/accounts/5883e3351756fc834d8ebe89/purchases?key=b84d3a153e2842b8465bcc4fde3d1839"')
    #os.system('command "hello" ')
    print("starting")
