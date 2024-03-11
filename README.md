# spring-JunitTest-with-Mockito

* Spring Boot is the most popular framework for building RESTful Services, offering great unit testing tools with Spring Boot Starter Test. Mockito is the most widely used framework for mocking and JUnit is commonly employed for Java unit testing.

* In this Spring Boot project, comprehensive JUnit tests have been crafted utilizing Mockito for the Controller, Service, and Repository layers. The Controller layer's methods, such as save(), fetchDataById(), and fetchDataByName(),fetchDataByCourse() which manage teacher entities' data (including ID, name, email, phone, and course taught), are rigorously tested to ensure correct functionality. Similarly, thorough test cases are implemented for the Repository and Service layers, validating the persistence and business logic aspects of the application.

* Mockito, along with MockBean and Builder, are integral components in crafting effective JUnit tests.

    * Mockito
        - Enables the creation of mock objects to simulate the behavior of dependencies, ensuring isolated testing environments 

    * MockBean   
        - Designed for Spring Boot applications, facilitates the creation of mock instances of Spring beans, aiding in dependency injection during testing

    * Buliders
        - The use of builders allows for the creation of test objects with customizable attributes, enhancing test coverage and flexibility in unit testing scenarios.
 
