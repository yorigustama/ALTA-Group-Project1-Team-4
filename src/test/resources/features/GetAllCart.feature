Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Project
  Scenario: Get all cart with valid parameter
    Given Get all cart with valid parameter
    When Send request get all cart
    Then Status code should be 200 OK
    And Response all cart body page should be 1
    And Validate get single cart JSON schema "GetAllCartSchema.json"