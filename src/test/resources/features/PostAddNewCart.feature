Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Project
  Scenario: Post add a new cart with valid json
    Given Add new cart with json "PostAddANewCart.json"
    When Send request post add new cart
    Then Status code should be 200 OK
    And Respon add cart body page should id 1
    And Validate post add cart JSON schema "PostAddANewCart.json"