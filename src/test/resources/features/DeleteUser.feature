@Tugas
Feature: ALTA QE BATCH 12 GROUP PROJECT 1
  @Tugas
  Scenario: Delete a user with valid user id
  Given Delete a user with valid user id 1
  When Send request delete user
  Then Status code should be 200 OK
  @Tugas
  Scenario: Delete a user with invalid user id
    Given Delete a user with valid user id 100000000
    When Send request delete user
    Then Status code should be 404 not found