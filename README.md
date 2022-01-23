Technical Test using Spring Boot 2.6, Mysql and Java 8 

Prerequisites:
-  Mysql: 8.0.27   
-  msql driver connector: mysql-connector-java-8.0.11.jar
-  Java 8
-  Spring Boot 2.6

Database:
- Schema: experian
- Table: data

How test it using Postman:
1. Get all the rows saved in our database - http://localhost:8080/experian/getAll
2. Insert or update a current value - http://localhost:8080/experian/updateRecord
    - Given a Json Object with the following structure.
  
          { 

             "msg_id": "9",

             "company_name": "Testing add row",

             "registration_date": "2021-01-22T14:34:06.132Z",

             "score": "4", 

             "directors_count": "10", 

             "last_updated": "2021-01-23T14:34:06.132Z"

          }

         If the id exists, the value will be updated, if not a new row will be added. 


Improvement:
1. Add test cases (important)
2. Refactor the code 
