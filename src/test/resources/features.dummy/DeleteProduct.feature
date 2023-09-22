Feature: PROJECT TEAM 4 PRODUCT
  @Tugas
#  Positive Case
  Scenario: Delete a product with valid parameter
    Given Delete a product with valid user id 1
    When Send request delete product
    Then Status code delete should be 200
    And Response body delete product should be 1
    And Validate delete product JSON schema "DeleteProductSchema.json"
  @Tugas
#  Negative Case
  Scenario: Delete a product with invalid parameter
    Given Delete a product with invalid user id 1
    When Send request delete product
    Then Status code delete should be 404
    And Response body delete product should be 1
    And Validate delete product JSON schema "DeleteProductSchema.json"


