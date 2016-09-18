# REST Service implementation using Service discovery pattern #

## Quick summary ##

This application implements a Service Discovery pattern using Netflix client implementation: [Ribbon] (https://github.com/Netflix/ribbon).

Instead of using Ribbon project on its own, this application uses Spring ecosystem to integrate it into the application.

It uses [Spring Boot](http://projects.spring.io/spring-boot/) to start Spring context and run the application and [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/) to integrate Netflix implementation into Spring.

During startup process, this service will try to register itself to any Eureka Server available in its configuration. It will provide Eureka with a lot of information about this service, like: host, port, health URL, main page, etc...

In addition, this service will send a heartbeat to Eureka from time to time in order to tell them it's alive.

##Version

* Spring Boot 1.4.0
* Spring Cloud 1.1.5

## How do I get set up? ##

In order to transform a common Spring Boot application into an Eureka Server, only three steps are needed:

* Add Spring Cloud dependency:

    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
        <version>1.1.5.RELEASE</version>
    </dependency>

* Enable Eureka initialization during Spring Boot startup using the annotation `@EnableEurekaClient` on the main class:

    @SpringBootApplication
    @EnableEurekaClient
    public class SngDemoUsersServiceApplication {
    ...
    }

* Add some configuration. Two configuration files are needed:

*bootstrap.yml*

    spring:
      application:
        name: users-service

*application.yml*

    server:
      port: 8001

    eureka:
      client:
        serviceUrl:
          defaultZone: http://eureka-server:8000/eureka/
      instance:
        leaseRenewalIntervalInSeconds: 5
        leaseExpirationDurationInSeconds: 15

The parameters `leaseRenewalIntervalInSeconds` and `leaseExpirationDurationInSeconds` have been modified in order to be able to make a demo fluently. 

_There parameters are not production ready_

### Deployment instructions ###

The application starts as a normal Spring Boot application:

* Run `mvn install` inside the proeject
* Go to `target` folder
* Run `java -jar sng-demo-users-service-1.0.0-SNAPSHOT.jar`
* _Optional_: If you're using [STS IDE](https://spring.io/tools/sts/all) you can use a view called `Boot Dashboard` to start/stop any Spring Boot project you have in your workspace