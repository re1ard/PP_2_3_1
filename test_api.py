import requests

if __name__ == "__main__":
    requests.post("http://127.0.0.1:8080/add", params = {"username":"test1", "password":"test", "email":"gav@gav.ru"}).text
    requests.post("http://127.0.0.1:8080/add", params = {"username":"test2", "password":"test", "email":"gav@gav.ru"}).text
    requests.put("http://127.0.0.1:8080/update", params = {"id":2,"username":"Semen", "password":"alahh", "email":"semen@228.ru"}).text
    requests.delete("http://127.0.0.1:8080/remove/2").text
    requests.get("http://127.0.0.1:8080/1").text