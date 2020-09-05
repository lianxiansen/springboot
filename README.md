C:\Windows\System32\drivers\etc\hosts
127.0.0.1 eureka1 eureka2

java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka1
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka2
http://eureka1:7001/
http://eureka2:7002/

java -jar springboot-web-0.0.1-SNAPSHOT.jar --config.producer.instance=1 --spring.profiles.active=webapi8001
java -jar springboot-web-0.0.1-SNAPSHOT.jar --config.producer.instance=2 --spring.profiles.active=webapi8002

java -jar springboot-webapp-0.0.1-SNAPSHOT.jar
http://localhost:9001/test/getUser?username=admin

java -jar hystrix-dashboard-0.0.1-SNAPSHOT.jar
http://localhost:11000/hystrix/monitor?stream=%20http%3A%2F%2Flocalhost%3A9001%2Factuator%2Fhystrix.stream

java -jar api-gateway-0.0.1-SNAPSHOT.jar
http://localhost:14000/springboot-webapp/test/getUser?username=admin
http://localhost:14000/springboot-web/test/getUser?username=admin