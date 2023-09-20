Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  Scenario: Get list user with valid parameter page
    Given Get list user
    When Send request get list
    Then Status code should be 200 OK