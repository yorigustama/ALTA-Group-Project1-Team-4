Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Project
  Scenario: Delete a cart with invalid user id
    Given Delete a cart without user id 11111
    When Send request delete cart
    Then Status code should be 404 not found