
A simple web-app backend to complement the front-end code.

Technologies used are Java, Spring, Hibernate, Jackson, Junit, Mockito, Mysql, AngularJs, JSP

Work Done
--------------
Based on the provided HTML, CSS, and JS, a Java-based REST API has been created and i have made changes to the front end part as well:

1. Saves expenses as entered to a database.

2. Retrieves them for display on the page when a new expense has been created.
 
3. Added a new column to the table displaying the VAT amount for each expense and the vat amount is UK 20% value of the expense.

4. Client side check for vat has been done.

5. written test cases for almost all the layers of the applications and covering almost all of the methods with different scenarios.

Changes in the front end
--------------------------

1. The default.html page has been changed to default.jsp page and it is mapped properly with spring viewResolver.

2. Moved all the static folders to webapp folder and it is mapped to spring in WebMvcConfig.java

3. in Codingtest.min.js , few changes have been made, the changes are below

     $Restangular.one("expenses").getList().then(function(expenses) 

    has been changed to 

     $Restangular.all("AlchemyBackend/allExpenses").customGET().then(function(expenses) {

    because we are returning an object not an array.

4. Similarly, the below line has been changed to support the object returned as object instead of an array

     $Restangular.one("expenses").post(null, $scope.newExpense).then(function() 

    to 

     $Restangular.one("AlchemyBackend/expense").post(null,$scope.newExpense).then(function() 

5. The input type for the amount has been changed from text to number , because it was not accepting decimal values.


Database Script
------------------

The db script is available is  in src/main/resources folder, please execute the script before running the application.

MYSQL Property file
------------------------

Please change the mysql properties file in src/main/resources (username and password) , the EntityConfig.java picks the configuration related information from mysql.properties file.

Steps to build the file
-------------------------

Go to the directory where the project root is located , and then type "mvn clean install", it would execute all the test cases available in the project and once it is deployed , you can deploy it on tomcat server and run it

Steps to run the project
________________________

go to "http://localhost:8080/AlchemyBackend/#/expenses" and it will be running with all the scenarios asked.

Hope you like the project, thank you

