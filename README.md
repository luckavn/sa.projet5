# SafetyNet Alerts

Alerts from SafetyNet is a service that gives first aid the means to better prepare and understand all situations.

## Prerequisite to run it

Java 1.8 JDK (or +)

Maven 3.5.X (or +)

Spring Boot 2.2.X (or +)

## Run app

```mvn
mvn clean install
mvn test (generate tests and test report)
mvn site (generate reportings)
```

```Spring Boot
mvn spring-boot:run (run app)
mvn spring-boot:stop (stop app)
```

## Documentation
Read documentation and commands for used language if hosted elsewhere (than local) : https://web.postman.co/collections/10913454-a6589645-2d9c-4fd5-8129-f62ae0da9b6d?version=latest&workspace=d2092b1f-dd08-49c5-8834-19d41e8827bb

## Contributing
Github repo is public, you can fork it and create improvements.
Please make sure to update tests as appropriate.

https://github.com/luckavn/sa.projet5/tree/release

## Bug troubleshooting (after 04/13/2020 defense with mentor)

```Spring Boot
Bug description : 
method "countAdult" & "countChild" from list returned code error.
```
After restarting app, it's ok. I was running on old instantiation of my app during project defense. 

I also added : 
- return info for all ADD methods
- return message with 500 error when childAlert endpoint return an empty list
