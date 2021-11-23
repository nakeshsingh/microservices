# This project is based on Microservice architecture.
### Technoly Used
Spring Boot and Spring Cloud

Language JAVA

MySQL and MSSQL database

### If you prefer video then there is separate YouTube video for each component of this project.

Services
1. [About microservice architecture with example](https://youtu.be/ZZ9RBFeDBlQ)
2. [Developing Spring Boot Application from scrach](https://youtu.be/uA6oSMUFh9Y)
3. [student microservice using MySQL database](https://youtu.be/J1bROg5PTJ4)
4. [course microservice using MS-SQL database](https://youtu.be/gr74Zs7GI0A)
5. [API Gateway- Spring Cloud Gateway](https://youtu.be/NrJMSSO531g)
6. [Eureka Server](https://youtu.be/qcUfWZMUBwc)
7. [Calling one microservice from another microservice using application name - RestTemplate](https://youtu.be/lysLDO1O-aU)
8. [Calling one microservice from another microservice using application name - WebClient](https://youtu.be/BlnURTFTnSk)
9. [Circuit Breaker - Resilience4j](https://youtu.be/2W7SEjS4O98)
10. [Spring Cloud sleuth](https://youtu.be/LS6Qp5y56Hw)
11. [Spring Cloud Zipkin](https://youtu.be/vitA265NwLk)
12. [Spring Cloud Config Server](https://youtu.be/ynx3NRHXVII)
13. [Spring Cloud Config client ](https://youtu.be/DhNTKk8tiso)
14. [RefreshScope to load configuration properties value from Config Server](https://youtu.be/S3VLvsNeoX8)

### How to start this project
1. Install JAVA, Maven, MySQL database, MS-SQL database : If you do not want to use database then you have to remove JPA and respective DB dependency from student and course microservice's pom.xml file
2. Download complete code from this repository and then import in your desired code editor (Eclipse or IntelliJ IDEA)
3. After installing database create user and databse to be used in student and course microservice. Refer [this video](https://youtu.be/J1bROg5PTJ4) to create user and database in MySQL. and [this video](https://youtu.be/gr74Zs7GI0A) to create user and database in MS-SQL.
4. Make sure you have created correct databse and given proper role to user as per shown in video.
## Runing project
  1. First of all run Eureka registry server (After successful running you can see Eureka dashboard at URL http://localhost:8083/ )
  2. Then Spring Gateway
  3. Then Config server
  4. Then student microservice and 
  5. Then course microservice 
  6. After all services running successful you should be able to see all above services registered on Eureka at URL : http://localhost:8083/
  7. Then Open Postman and hit Rest API endpoints discussed in Video.

Thanks.

