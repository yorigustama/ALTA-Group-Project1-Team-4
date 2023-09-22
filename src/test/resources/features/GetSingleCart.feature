Feature: ALTA QE BATCH 12 GROUP PROJECT 1
  Scenario: Get single cart with valid user id
    Given Get single cart valid parameter id 1
    When Send request get single cart
    Then Status code should be 200 OK
    And Response single cart body page should id 1
    And Validate get single cart JSON schema "SingleCartSchema.json"

  Scenario: Get single cart with invalid user parameter
    Given Get single cart with parameter id 1000000
    When Send request get single cart
    Then Status code should be 404 not found
