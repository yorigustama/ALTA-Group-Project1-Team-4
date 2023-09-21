Feature: ALTA QE BATCH 12

  Scenario: Pacth update user with valid json and user id
    Given Update user patch with valid json "UpdateUser.json" and user id 1
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Terry" and lastName was "Owais"