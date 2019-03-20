#About Temperature REST API

Gradle version 5.2.1
Java Version 11.0.2 (Oracle Corporation 11.0.2+9-LTS)

##Setup
It assumes there is a MySQL database already called 'Temperatures'.
The table itself will be generated and prepopulated with mock data at start up.
In application.properties update the 
            URL
            username 
            password

### Following are instructions using Temperatures REST service
There is a gui for running the API via browser:
http://localhost:8080/

You may need to add the plugin 'Lombok' if the IDE is telling you it can't find certain annotation

### API Calls
GET ("/list")
returns a list of all temperatures in the database in Fahrenheit and Celsius

POST ("/addTemp/{temp}")
adds new temperature to database

PUT ("/updateTemp/{id}/{temperature}")
updates with new temperature per the ID

DELETE("/removeTemp/{id}")
deletes a single row if the ID is in the table
