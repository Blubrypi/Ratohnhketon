# Ratohnhketon
A Spring Boot Application to perform CRUD operations in MongoDB.

## MongoDB
MongoDB is a general purpose, document-based, distributed (NoSQL) database built for modern application developers and for the cloud era. It stores data in BSON (Binary JSON) documents. Mongo databases use collections instead of tables and documents instead of records. 

### Running This Application
#### 1.Start the Application
   Import the project in an IDE and run the Spring application to start it in the embedded tomcat server, or run the built .war file in the target directory in your command line program.
#### 2.Accessing the endpoints
  Swagger has been configrured in the application, to access the Swagger UI, go to: http://localhost:8080/swagger-ui.html#. Alternatively, use applications like Postman to access the API endpoints, which are as follows:
### POST Mapping
> http://localhost:8080/patient <br>
To add a new document, request body consists of a patient document, and response consists of the saved document with its ID.
### GET Mapping
> http://localhost:8080/patient <br>
Get all documents.
> http://localhost:8080/patient/{patientId} <br>
Get particular document, path variable contans patient Id, returns particular document, throws an error if it doesn't exist.
, ### PUT Mapping
> http://localhost:8080/patient <br>
Update an existing document, request body consists of a patient document, returns the updated document, throws an error if it doesn't exist, or the data is unchanged.
### Delete Mapping
> http://localhost:8080/patient/{patientId} <br> 
Delete an existing document, path variable contans patient Id, returns all documents after deletion of the document, throws an error if it doesn't exist.
