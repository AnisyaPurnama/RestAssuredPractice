Feature: Users

  #GET
  Scenario: Retrieve user details
    Given I send a GET request to "/api/users"
    Then the response status should be "200"
    And the JSON response should contain "data"
    And the JSON response should have "$..email" with the text "janet.weaver@reqres.in"

    #POST
  Scenario: Create a user
    Given I send a POST request to "/api/users" with the following data:
      | name     | Ani Weet       |
      | job      | QA Engineer    |
    Then the response status should be "201"
    And the JSON response should contain "id"
    And the JSON response should have "$..name" with the text "Ani Weet"

  Scenario: Register a new user with valid data
    Given the user is on the registration page
    When the user enters valid registration details
    And clicks on the "Register" button
    Then the user should be successfully registered

  Scenario: Register a new user with invalid data
    Given the user is on the registration page
    When the user enters invalid registration details
    And clicks on the "Register" button
    Then an error message should display
    But the registration form should remain accessible

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid username
    And the user enters a valid password
    And clicks on the "Sign In" button
    Then the user should be successfully logged in

  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username
    And the user enters a valid password
    And clicks on the "Sign In" button
    Then an error message should display
    But the "Re-login" option should be available

    #PUT
  Scenario: Update user details
    Given I send a PUT request to "/api/users/2" with the following data:
      | name     | Updated Name   |
      | job      | Updated Job    |
    Then the response status should be "200"
    And the JSON response should have "$..name" with the text "Updated Name"

    #PATCH - Partial Update User Details
  Scenario: Partially update user details
    Given I send a PATCH request to "/api/users/2" with the following data:
      | job      | Updated Job    |
    Then the response status should be "200"
    And the JSON response should have "$..job" with the text "Updated Job"

    #DELETE
  Scenario: Delete a user
    Given I send a DELETE request to "/api/users/2"
    Then the response status should be "204"