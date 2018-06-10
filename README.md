
# REST API
RESTful API built using Spring Boot, Spring Data JPA, MySQL

## Installation<a name="installation"></a>
### Running Locally
Make sure you have [MySQL](https://www.mysql.com/) installed.

1. Clone or Download the repository.

	```
	$ git clone https://github.com/bizarrecode/rest-api.git
	$ cd rest-api
	```
2. Edit database config.

	```
	$ sudo gedit src/main/resources/application.properties
	```
3. Start the application.

	```
	$ mvn spring-boot:run

Your app should now be running on [localhost:8080](http://localhost:8080/).

## Test Result

1. Add employee

![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/add01.png)
![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/add02.png)

2. Get all employees

![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/all01.png)

3. Get employee

![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/get01.png)

4. Update employee

![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/update01.png)
![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/update02.png)

5. Delete employee

![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/delete01.png)
![Screenshot](https://raw.githubusercontent.com/bizarrecode/rest-api/master/src/main/resources/images/delete02.png)

