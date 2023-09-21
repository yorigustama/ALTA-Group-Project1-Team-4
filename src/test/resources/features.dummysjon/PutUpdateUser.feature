Feature: ALTA QE BATCH 12

  Scenario: Put update user with valid json and user id
    Given Update user with valid json "UpdateUser.json" and user id 1
    When Send request put update user
    Then Status code should be 200 OK