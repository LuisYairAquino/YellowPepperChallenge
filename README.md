# Yellow Pepper Challenge API Pet Store

This is a simple starter project for Serenity with Cucumber 6 and RestAssured

## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity Dojo**](https://www.serenity-dojo.com) - Tailored BDD and Test Automation Training and Mentoring

* # Command to run the project
* gradle clean test
*
* # Challenge Responses

***Test Cases for API testing***

Here are some proposed test cases for the Swagger Petstore API:


***GET /pets***
Validate that the response status is 200 OK.
Validate the structure of the returned data (e.g., it contains id, name, category, etc.).


***POST /pets***
Validate that a new pet can be added successfully.
Validate the response status is 201 Created.
Validate that the returned pet data matches the input data.


***GET /pets/{id}***
Validate that retrieving a pet by ID returns the correct pet.
Validate the response status is 200 OK.
Validate that a non-existent pet ID returns a 404 Not Found status.


***PUT /pets/{id}***
Validate that updating an existing pet's details is successful.
Validate that the response status is 200 OK.
Validate that the updated data is reflected in a subsequent GET request.


***DELETE /pets/{id}***
Validate that a pet can be deleted successfully.
Validate that the response status is 204 No Content.
Validate that retrieving the deleted pet returns a 404 Not Found status.


***GET /pets with query parameters***
Validate that filtering pets by status returns the correct results.

# 2. Taks about performance test

***The test cases I can perform could be:***

***Load Testing:*** Measure how the API handles a specific number of concurrent users (100, 200, 1000)
***Stress Testing:*** We can increment gradually and determine the maximum load the API can handle before failing
***Endurance testing:*** Test the API under a significant load over an extended period to check for performance degradation

