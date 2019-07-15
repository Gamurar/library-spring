Library online (for java 11.0.3 +)
-------------------
![Docker Pulls](https://img.shields.io/docker/pulls/gamurar/library.svg)
-------------------

Java open source online library.

Used technologies:
- Spring Boot
- Spring Data
- Role Based Spring Security
- Spring MVC
- JPA
- Thymeleaf
- MySQL
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

Access the deployed web application at: http://localhost:8080/

Access the api section at: http://localhost:8080/api/books

username : api-user

password : 123qweASD

The instructions above will let you run the application with default settings and configurations.
Please read the instructions on how to connect to MySQL, configure an email server and configure other subsystems


### Api Documentation:
-------------------

Documentation available from the swagger ui <http://localhost:8080/swagger-ui.html>


