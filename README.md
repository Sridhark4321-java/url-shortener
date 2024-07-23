# url-shortener

This project shows URL shortneing using 
Spring Boot 3.3 
Spring Web 
Guava 33.2.1
OpenApi 2.0.2


URLS :

This endpoint will return shortened url from long url string.

Endpoint : http://localhost:8080/encode
Method Type : POST 
Input String with body ( long url string )
Results in JSON format




This endpoint will return the long url from short id/url.

Endpoint : http://localhost:8080/decode/{id}
Method Type : GET 
Input short/Id in the url (short url/id)
Results in JSON format

Swagger/OpenApi : http://localhost:8080/swagger-ui.html 

 
