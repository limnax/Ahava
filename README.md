# Microservices using openFeign Client

This project is a microservices-based application that utilizes the OpenFeign client for communication between the microservices. The project demonstrates how to 
design and implement microservices that interact with each other using the OpenFeign client. Each microservice has its own specific functionality, such as managing 
subjects, classes, and students. The services communicate with each other to fulfill business requirements, leveraging the capabilities of the OpenFeign client to make 
remote API calls between services.

# Installations

- Java Development Kit (JDK): The project requires Java 17 or a compatible version. 
- Apache Maven: Maven is used as the build and dependency management tool for the project. 
Ensure that Maven is installed on your system and properly configured. You can download Maven from the Apache Maven website.
- PostgreSQL Database: The project uses PostgreSQL as the database system. Make sure PostgreSQL is installed and running on your machine. 

Starting the services
```
cd discovery-server && mvn spring-boot:run
cd student && mvn spring-boot:run
cd class && mvn spring-boot:run
cd subject && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
```
Add classes- /POST http://localhost:8970/classes
```
{
    "className":"STD6",
    "stream":2
}
```
Add Subjects - /POST http://localhost:8970/subjects

```
{
    "subjectName":"Science",
    "studentId":1
}
```
Add Students - /POST http://localhost:8970/students

```
{
    "firstname":"sammy",
    "lastname":"oduor",
    "classId":2
}
```
Now access the students in a class and the subjects each student take through
/GET http://localhost:8970/classes/2 where id 2 is the classId
```
{
    "classId": 2,
    "className": "STD1",
    "stream": 2,
    "students": [
        {
            "studId": 1,
            "firstname": "Cecilia",
            "lastname": "Waithera",
            "classId": 2,
            "subjects": [
                {
                    "subjectId": 1,
                    "subjectName": "Maths"
                },
                {
                    "subjectId": 2,
                    "subjectName": "Eng"
                },
                {
                    "subjectId": 52,
                    "subjectName": "Geog"
                },
                {
                    "subjectId": 102,
                    "subjectName": "CRE"
                },
                {
                    "subjectId": 152,
                    "subjectName": "Science"
                }
            ]
        },
        {
            "studId": 52,
            "firstname": "moses",
            "lastname": "ngigi",
            "classId": 2,
            "subjects": []
        },
        {
            "studId": 2,
            "firstname": "John",
            "lastname": "Doe",
            "classId": 2,
            "subjects": []
        },
        {
            "studId": 102,
            "firstname": "sammy",
            "lastname": "oduor",
            "classId": 2,
            "subjects": []
        }
    ]
}
```
Active instances on Eureka Server  http://localhost:8761/
![eureka](https://github.com/limnax/Ahava/assets/6594309/034bc960-4356-47fc-bc60-ea32c413b654)


