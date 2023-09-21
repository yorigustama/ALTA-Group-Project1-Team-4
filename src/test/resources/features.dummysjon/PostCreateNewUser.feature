Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  Scenario: Post create a new user with valid json
    Given Create new user with valid json "PostCreateNewUser.json"
    When Send request post create new user
    Then Status code should be 200 OK
    And Validate post create JSON schema "PostCreateNewUserSchema.json"
