# Ratohnhketon
A Spring Boot Application to perform CRUD operations in MongoDB.

## MongoDB
MongoDB is a general purpose, document-based, distributed (NoSQL) database built for modern application developers and for the cloud era. It stores data in BSON (Binary JSON) documents. Mongo databases use collections instead of tables and documents instead of records. 

## Running This Application
#### 1. Start the Application
   Import the project in an IDE and run the Spring application to start it in the embedded tomcat server, or run the built .war file in the target directory in your command line program.
#### 2. Accessing the endpoints
  Swagger has been configrured in the application, to access the Swagger UI, go to: http://localhost:8080/swagger-ui.html#. Alternatively, use applications like Postman to access the API endpoints, which are given below.<br><br>
### POST Mapping
- http://localhost:8080/patient <br>
> To add a new document, request body consists of a patient document, and response consists of the saved document with its ID.
### GET Mapping
- http://localhost:8080/patient <br>
> Get all documents in the collection.<br>  
- http://localhost:8080/patient/{patientId} <br>
> Get particular document, path variable contans patient Id, returns particular document, throws an error if it doesn't exist.
### PUT Mapping
- http://localhost:8080/patient <br>
> Update an existing document, request body consists of a patient document, returns the updated document, throws an error if it doesn't exist, or the data is unchanged.
### Delete Mapping
- http://localhost:8080/patient/{patientId} <br> 
> Delete an existing document, path variable contans patient Id, returns all documents after deletion of the document, throws an error if it doesn't exist.

### The Project Structure
The project has the following directories: <br>
1. **pom.xml** : Consists of the maven configurations for the project, including but not limited to, its dependencies and plugins.
2. **src/main**:
   - java: Contains the entire server code of the application.
   - resources: Contains various configurations, templates including *application.properties* (which contains the database details).
3. **config**: Contains the configuration files for Swagger, Mongo templates, etc...
4. **controller**: Describes the REST controller with its various APIs.
5. **controller.handler**: Handles the exceptions on its own without explicit handling in try/catch blocks.
6. **dto**: Contains the DTO classes for the relative document models (entities).
7. **exception**: Consists of the various exceptions in the application wrapped into the main Exception class.
8. **model**: Consists of the document models (Entity classes).
9. **repository**: Contains the repository interface which extends the Mongo repository with the particular entity and its unqiue key's data-type as arguments.
10. **service**: Defines the various service methods.
11. **service.impl**: Implements the methods which define the business logic.
12. **util**: Contains the various utility methods and variables that are used in the application such as error messages, mappers, etc...

Created by Abdul Rahman
