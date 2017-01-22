import requests
headers = {"Content-Type": "application/json", "Accept": "application/json"}
data = {"merchant_id\": "57cf75cea73e494d8675ec49\","medium\": "balance\", "purchase_date\": "2017-01-22\","amount\": 1, "description\": "string\"}
url = "http://api.reimaginebanking.com/accounts/5883e3351756fc834d8ebe89/purchases?key=b84d3a153e2842b8465bcc4fde3d1839"
response = requests.post(url, data=data, headers=headers)
