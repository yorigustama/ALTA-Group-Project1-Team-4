Feature: ALTA QE BATCH 12 PROJECT GROUP 1 TEAM 4
  Scenario: Get list user with valid parameter page
    Given Get list user with valid parameter
    When Send request get list
    Then Status code should be 200 OK