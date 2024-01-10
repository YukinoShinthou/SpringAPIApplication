import requests

id = int(input("Write an id of person\n"))

URL = f"http://localhost:8011/peope/{id}"

r = requests.get(url = URL)

person = r.json()

print("Person details : {person}")