import sys
import os
import subprocess
import serial
import time
ser = serial.Serial('/dev/ttyACM0', 9600)
cmd = '''curl -X POST --header "Content-Type: application/json" --header "Accept: application/json" -d "{\"merchant_id\": \"57cf75cea73e494d8675ec49\",\"medium\": \"balance\",\"purchase_date\": \"2017-01-22\",\"amount\": 1,\"description\": \"string\"}" "http://api.reimaginebanking.com/accounts/5883e3351756fc834d8ebe89/purchases?key=b84d3a153e2842b8465bcc4fde3d1839"'''
args=cmd.split();
while 1:
    ser.readline()
    #subprocess.check_output(args)
    print(subprocess.call("sudo bash /home/pi/Desktop/punsh.sh",shell=True))
    time.sleep(3)
