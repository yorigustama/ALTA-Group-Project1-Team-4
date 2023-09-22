@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Tugas
  Scenario: Post create a new user with valid json
    Given Create new user with json "PostCreateNewUser.json"
    When Send request post create new user
    Then Status code should be 200 OK
    And Respon body patch firstName was "Muhammad" and lastName was "Ovi"
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
  @Tugas
  Scenario: Post create a new user with valid json
    Given Create new user with json "PostCreateNewUserInvalid.json"
    When Send request post create new user
    Then Status code should be 400 Bad Request
