# REST example with Spring Boot + Kotlin
This is a simple example for a REST service that adhere to the 3rd level of the
**Richardson Maturity Model** (https://martinfowler.com/articles/richardsonMaturityModel.html)
using Spring Boot + Kotlin and an integrated H2 Database.

# Application Structure / Layers
## Controller 
Spring Controller class for providing REST endpoints according to layer 3 of the **Richardson Maturity Model** (details see link 1.).
For testing the REST services you could use e.g. POSTMAN (link 8). 

### Level 0
Using HTTP only as a mechanism for transportation of remote interaction - 
often the URL resemble method calls or just provide one entry point which analyses the payload 
and takes action according to its content.

### Level 1 - Resources
The single entry point is replaced by multiple resource endpoint - often designed according to
Domain Driven Design.

### Level 2 - HTTP verbs
Relying on the HTTP verbs to communicate what is done with the resource (see link 7).

Most common verbs used are:
* **GET**: The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
* **HEAD**: The HEAD method asks for a response identical to that of a GET request, but without the response body.
* **POST**: The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server
* **DELETE**: The DELETE method deletes the specified resource.
* **PUT**: The PUT method replaces all current representations of the target resource with the request payload.
* **OPTIONS**: The OPTIONS method is used to describe the communication options for the target resource.  
* **PATCH**: The PATCH method is used to apply partial modifications to a resource.

## Model 
The data model / domain model of the application. 
Decorated with JPA annotations for persistence. 

## Repo
Spring Data repository for accessing the data storage.

## Service
Service layer for encapsulating logic and data access.

## Resources 
### application.yml
The file includes the configuration for the application, e.g. database settings. 

## Database integration 

# Spring and Kotlin
To be able to use Spring the `kotlin-maven-allopen` dependency with **spring compiler plugin** is needed.
## Autowiring 
There are 3 possibilities to autowire beans created by Spring in Kotlin classes.
1. @Autowired annotation for a **field** in class (must be late init and var)
    ```kotlin
    class UserController {
        @Autowired
        lateinit var userService: UserService
        // ...
     } 
    ```
2. constructor injection without annotation (since Spring 4.3)
    ```kotlin
        class UserServiceImpl(val userRepo: UserRepository) : UserService {
            override fun save(user: User): User? = userRepo.save(user)
        // ... 
       }
    ```
3. @Autowired annotation for **constructor** 
    ```kotlin
    class AddressServiceImpl @Autowired constructor(private val addressRepo: AddressRepository) : AddressService {
        override fun findByDetails(street: String, city: String, country: String) = addressRepo.findByStreetContainsAndCityContainsAndCountryContains(street, city, country)
    }
    ```
# Swagger 
The project includes Swagger2 with an UI which is accessible on 
http://localhost:8080/swagger-ui.html

This can be used to test the REST endpoint and for API documentation.



### Links
1. Richardson Maturity Model: https://martinfowler.com/articles/richardsonMaturityModel.html
2. Spring Boot:  https://projects.spring.io/spring-boot/
3. Spring Data: http://projects.spring.io/spring-data/
4. H2 database: http://www.h2database.com/html/main.html
5. Kotlin reference:  https://kotlinlang.org/docs/reference/
6. Domain Driven Design
    1. Book: Domain-Driven Design: Tackling Complexity in the Heart of Software by Eric J. Evans
    2. https://martinfowler.com/tags/domain%20driven%20design.html
7. HTTP verbs: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
8. Postman REST Client: https://www.getpostman.com/
9. Swagger: https://swagger.io/
10. Spring Boot Swagger integration: https://springfox.github.io/springfox/



