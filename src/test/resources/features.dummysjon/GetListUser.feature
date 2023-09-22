Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  Scenario: Get list user with valid parameter page
    Given Get list user
    When Send request get list
    Then Status code should be 200 OK

  Scenario: Get list user with invalid parameter page
    Given Get list user invalid parameter id 7
    When Send request get list invalid
    Then Status code should be 200 OK
