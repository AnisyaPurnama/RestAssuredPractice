Feature: Users

  #GET
  Scenario: Retrieve user details
    Given I send a GET request to "/api/users"
    #TODO enum
    Then the response status should be "OK"
    And the JSON response should contain "DATA"

    #POST
  Scenario: Create a user
    Given I send a POST request to "/api/users" with the following data:
    #TODO
      | name | Ani Weet    |
      | job  | QA Engineer |
    Then the response status should be "CREATED"
    And the JSON response should contain "CREATED USER"

  Scenario: Register a new user with valid data
    Given the user is on the registration page
    When the user enters valid registration details
    Then the user should be successfully registered

  Scenario: Register a new user with invalid data
    Given the user is on the registration page
    When the user enters invalid registration details
    Then an error message should display

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid username
    And the user enters a valid password
    Then the user should be successfully logged in

  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username
    And the user enters a valid password
    Then an error message should display

    #PUT
  Scenario: Update user details
    Given I send a PUT request to "/api/users/2" with the following data:
      | name | Updated Name |
      | job  | Updated Job  |
    Then the response status should be "OK"
    And the JSON response should contain "USER_UPDATED"

    #PATCH - Partial Update User Details
  Scenario: Partially update user details
    Given I send a PATCH request to "/api/users/2" with the following data:
      | job | Updated Job |
    Then the response status should be "OK"
    And the JSON response should contain "USER_PARTIAL_UPDATE"

    #DELETE
  Scenario: Delete a user
    Given I send a DELETE request to "/api/users/2"
    Then the response status should be "NO_CONTENT"