[![Build Status][travis-badge]][travis-badge-url]

Spring Cloud Example
==========================
This is a  [**Spring Cloud**](http://projects.spring.io/spring-cloud/) based microservices example.
It is based on [Spring Cloud Camden](https://spring.io/blog/2016/09/26/spring-cloud-camden-release-and-brixton-sr6-are-available) release
and Spring Boot version 1.4.1.RELEASE. 

# Modules
The project consist of multiple modules and can be classified into following categories:

1. **Services**
    1. Book Service: Provides information about book title and author name.
        1. `book-model`
        2. `book-service`
    2. Author Service: Provides information about author's biography.
       1. `author-model`
       2. `author-service` 
    3. Review Service: Provides book reviews.
        1. `review-model`
        2. `review-service`
    4. Composite Book Service: It's a composite service which calls book, author, and review atomic services to
    provide complete information about a book.
        ..1. `book-composite-service`
        
2. **Support**
    1. Discovery Server: Eureka Server
        1. `discovery-server`
    2. Gateway Server: Zuul Server
        1. `gateway-server`
    3. Hystrix Dashboard
        1. `hystrix-dashboard`
    4. Turbine Server
        1. `turbine-server`


# Build
Execute the following command from the parent directory:
```
mvn clean install
```

[travis-badge]: https://travis-ci.org/indrabasak/spring-cloud-example.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/spring-cloud-example/