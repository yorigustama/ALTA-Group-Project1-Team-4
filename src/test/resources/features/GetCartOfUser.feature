Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Project
  Scenario: Get cart of user with valid user id
    Given Get cart of user valid parameter id 5
    When Send request get cart of user
    Then Status code should be 200 OK
    And Response cart user body page should id 5
    And Validate get cart of user JSON schema "CartOfUserSchema.json"

  Scenario: Get cart of user with invalid parameter page
    Given Get cart of user with parameter page 3000
    When Send request get cart of user
    Then Status code should be 404 not found