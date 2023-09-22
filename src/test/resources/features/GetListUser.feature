@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Tugas
  Scenario: Get list user with valid parameter page
    Given Get list user
    When Send request get list
    Then Status code should be 200 OK
    And Response body page shoud be 1
    And Validate get list user JSON schema "ListUserSchema.json"

