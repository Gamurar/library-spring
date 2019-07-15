Library online (for java 11.0.3 +)
-------------------

Java open source online library.

<img src="https://raw.githubusercontent.com/Gamurar/docs/master/library-spring/screenshot-home.png"> 

Book details page       				 |  Edit book page
:---------------------------------------:|:---------------------------------------:|
<img src="https://raw.githubusercontent.com/Gamurar/docs/master/library-spring/screenshot-book-detail.png"> | <img src="https://raw.githubusercontent.com/Gamurar/docs/master/library-spring/screenshot-edit-book.png">

Used technologies:
- Spring Boot
- Spring Data
- Role Based Spring Security
- Spring MVC
- JPA
- Thymeleaf
- MySQL
- Liquibase
- REST API


Get the code:
-------------------
Clone the repository:
     
	 $ git clone git@github.com:Gamurar/library-spring.git

If this is your first time using Github, review http://help.github.com to learn the basics.

You can also download the zip file containing the code from https://github.com/Gamurar/library-spring/archive/master.zip

To build the application:
-------------------	
From the command line with Maven installed:

	$ cd library-spring
	$ mvn clean install
if Maven is not installed, use maven wrapper
       
	$ mvmw clean install
	


Run the application from Spring boot 
-------------------

       $ cd web
       $ mvn spring-boot:run
if Maven is not installed, use maven wrapper
       
	   $ mvmw spring-boot:run

Run the application from Spring boot in eclipse
-------------------

Right click on com.example.demo.web.Launcher

run as Java Application

### Access the application:
-------------------

- Access the deployed web application at: http://localhost:8080/

  - Sign in data

	   ROLE_ADMIN<br/>
		username : admin<br/>
		password : admin<br/>

	   ROLE_USER<br/>
		username : user<br/>
		password : user<br/>

	   ROLE_USER, ROLE_OPERATOR, ROLE_ADMIN<br/>
		username : cat<br/>
		password : meow<br/>

- Access the api section at: http://localhost:8080/api/books

  - Sign in data

	   ROLE_API_CLIENT<br/>
		username : api-user<br/>
		password : 123qweASD<br/>

The instructions above will let you run the application with default settings and configurations.
Please read the instructions on how to connect to MySQL, configure an email server and configure other subsystems


### Api Documentation:
-------------------

Documentation available from the swagger ui <http://localhost:8080/swagger-ui.html>


