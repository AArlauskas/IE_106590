Read me file for lab2
Description of work:

lab2.1

1. Created necessary folders for the lab2
2. Removed other versions of Java
3. Installed Java 11
4. Downloaded Tomcat server 9
5. Pasted the Tomcat server to the repository folder
6. Added %CATALINA_HOME% environment variable
7. Used the startup.sh script to start the server
8. Inspected the logs
9. Added the required users and roles for the Tomcat server
10. Created maven project 
11. Exported to war file
12. Deployed the application to the Tomcat server
13. Tested the deployed application
14. Configured Tomcat hosting so that Intelij would do it automatically
15. Adapted the application to return a custom Hello message
16. Tested the application changes
17. Adapted the application to throw an exception 
18. Redeployed application on Tomcat
19. Checked out the logs for the exception

lab 2.2
1. Created maven project for lab2.2
2. Changed the main method so that it would start the Jetty server
3. Created a separate class for returning a custom HTML based hello message

lab 2.3
1. Used Intelij's SpringInitializr to create the project
2. Added spring Web dependency
3. Started the application and tested on browser
4. Created HTML based Greeting controller with Thymeleaf
5. Created the hello page (greeting.html)
6. Started and tested the application
7. Added index.html page as shown in the tutorial
8. Retested the application
9. Created RestApi for the welcome message
10. Created the Model class for the Greeting
11. Mapped the endpoint for /api/welcome
12. Tested the endpoints both with the browser and postman

lab 2.4
1. Inspected the example Api
2. Created the ShowsController and QuotesController with required methods
3. Created Model classes for Show(id,name) and Quote(id, name, showId)
4. Created Dtos respectively to the classes in step 3
5. Created QuotesService and ShowsService with static values
6. Filled Services with methods for passing required data to the controllers
7. Implemented Controller endpoints using the service logic.
8. Tested out all of the endpoints


Questions:
1. What are the responsibilities/services of a “servlet container”?
Answer: Servlet is used to proccess the requests that are sent to the server.
It has these steps: initialise, service and destroy.
It is used to serve dynamic content and use the built in logic to give responses to the client.

2. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)
Answer: 
The Model-View-Controller (MVC) architecture for building web applications is one of the oldest paradigms in computer science. The MVC architecture for web applications is supported by the Spring MVC component of the Spring framework.
An HTTP request is sent to the Java Servlet container (e.g., Tomcat, Jetty, etc...) The HTTP request is first intercepted by the controller written in Java. The controller returns a Java Server Page (JSP) which is rendered on the server and returned to the web browser as static HTML.
The diagram below shows how a Java MVC application interacts with the client side of the web application in a web browser.
Example: GreetingMessage. Request is sent to the service. Service finds the right endpoint. It takes static html template. It fills the data into the model based on the server logic. It returns a rendered html with filled in values.


3. Inspect the POM.xml for the previous SpringBoot projects. What is the role of the “starters” dependencies?
Answer: Since Spring boot is a library, it's intention is to provide programmer with easy interface that is easy to set up.
"Starters" are dependencies provided by SpringBoot that usually work out of the box without much configuration required by the programmer.
Their aim is to provide core concepts and libraries for the use of running the project.

4. Which annotations are transitively included in the @SpringBootApplication?
Answer: 
4.1. @Configuration to enable Java-based configuration
4.2. @ComponentScan to enable component scanning.
4.3. @EnableAutoConfiguration to enable Spring Boot's auto-configuration feature.

5. Search online for the topic “Best practices for REST APIdesign”. From what you could learn, select your “top 5”practices,and briefly explain them in you own words.

Answer:
1. Receive and Respond in JSON (Because XML sucks :))
2. Use specific and accurate error response codes. It means to not use BadRequest for everything. For example, if you are looking for for something and it's not found,
you should use 404(NotFound). If BadRequest is used, giving a descriptive message is key to having an understandable API.
3. Name the endpoints wisely. if we want to get cars, then the endpoint should be api/cars. If we want a specific car by id, it should be /api/cars/1. Try to make it as simple
and reasonable as possible without writing convoluted endpoints.
4. Use correct HTTP request methods. If you want to create a user, use POST instead of PUT.
5. Use security provided. Try to use SSL whenever possible, to make sure that it is not in danger for ManInTheMiddleAttacks