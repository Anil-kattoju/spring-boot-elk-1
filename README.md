# spring-boot-elk
Spring Boot's Logging to ELK:
* custom fields sending to Logstash:
    * `serviceName` - name of service
    * `serviceVersion` - current version of service
    * `X-Request-ID` -  Request ID from HTTP Header (if missing - generate random UUID)
* HTTP Request/Response logging

## How to run

* Run ELK:
```
cd docker
docker-compose up --build
```

* Run microservice:
```
cd ..
./gradlew bootRun
```

* Send requests:
```
curl -X GET http://localhost:8080/api/log
curl -X GET -H 'X-Request-ID:helloGetWorld' http://localhost:8080/api/log

curl -X POST http://localhost:8080/api/log -d 'Hello World!'
curl -X POST  -H 'X-Request-ID:helloPostWorld' http://localhost:8080/api/log -d 'Hello World!'
```