@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1
  @Tugas
  Scenario: Pacth update user with valid json and user id
    Given Update user patch with json "UpdateUser.json" and user id 1
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Terry" and lastName was "Owais"
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
  @Tugas
  Scenario: Pacth update user with invalid json and user id
    Given Update user patch with json "UpdateUserinvalid.json" and user id 1
    When Send request patch update user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Terry" and lastName was "Owais"
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
  @Tugas
  Scenario: Pacth update user with json and invalid user id
    Given Update user patch with json "UpdateUser.json" and user id 1111111
    When Send request patch update user
    Then Status code should be 404 not found
