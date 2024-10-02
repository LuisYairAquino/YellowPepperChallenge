Feature: Swagger Petstore API

  Scenario: Retrieve all pets
    Given the pet store API is available
    When I request a list of pets
    Then the response status should be 200 OK
    And the response should contain pet details

  Scenario: Add a new pet
    Given the pet store API is available
    When I add a new pet with the following details
      | name  | category   | status   |
      | Fido  | Dogs            | available|
    Then the response status should be 201 Created
    And the pet data should match the input

  Scenario: Retrieve pet by ID
    Given the pet store API is available
    When I retrieve a pet by ID
    Then the response status should be 200 OK

  Scenario: Update pet information
    Given the pet store API is available
    When I update the pet with ID 123
    Then the response status should be 200 OK
    And the pet data should be updated

  Scenario: Delete a pet
    Given the pet store API is available
    When I delete the pet with ID 123
    Then the response status should be 204 No Content
    And retrieving the pet should return a 404 Not Found
