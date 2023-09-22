@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1
  @Tugas
  Scenario: Put update user with valid json and user id
    Given Update user with json "UpdateUser.json" and user id 1
    When Send request put update user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Terry" and lastName was "Owais"
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
  @Tugas
  Scenario: Put update user with invalid json and user id
    Given Update user with json "UpdateUserInvalid.json" and user id 1
    When Send request put update user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Terry" and lastName was "Owais"
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
  @Tugas
  Scenario: Put update user with valid json and user id
    Given Update user with json "UpdateUser.json" and user id 1000000000
    When Send request put update user
    Then Status code should be 404 not found