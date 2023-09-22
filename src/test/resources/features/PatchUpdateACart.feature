Feature: ALTA QE BATCH 12 GROUP PROJECT 1

  @Project
  Scenario: Patch update a cart with valid json and user id
    Given Update user patch with valid json "UpdateCart.json" and user id 1
    When Send request patch update cart
    Then Status code should be 200 OK
    And Response body patch id was 1 and quantity was 1
    And Validate patch update cart json schema "PatchUpdate.json"