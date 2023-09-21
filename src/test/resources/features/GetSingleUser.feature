@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Tugas
  Scenario: Get single user with valid id user
    Given Get single user with parameter id 2
    When Send request get single user
    Then Status code should be 200 OK
    And Respon single user body page should id 2
    And Validate get list user JSON schema "SingleUserSchema.json"
  @Tugas
  Scenario: Get single user with invalid id user
    Given Get single user with parameter id 2222222
    When Send request get single user
    Then Status code should be 404 not found
