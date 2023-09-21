Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  Scenario: Get list user with valid parameter page
    Given Get list user
    When Send request get list
    Then Status code should be 200 OK
    And Response body page shoud be 1
    And Validate get list user JSON schema "ListUserSchema.json"

  Scenario: Get list user with invalid parameter page
    Given Get list user with paramater page 10000
    When Send request get list
    Then Status code should be 200 OK
    And Response body page shoud be 1
    And Validate get list user JSON schema "ListUserSchema.json"