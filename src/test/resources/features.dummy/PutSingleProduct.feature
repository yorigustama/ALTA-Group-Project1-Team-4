Feature: PROJECT TEAM 4 PRODUCT
#  Positive Case
  @Tugas
  Scenario: Put single product with valid parameter
    Given Put Single product with valid json "PutSingleProduct.json" and user id 1
    When Send request put single product
    Then Status code should be 200 oK
    And Response body put single should be 1
    And Validate put single product JSON schema "PutSingleProductSchema.json"

#  Negative Case
  @Tugas
  Scenario: Put single product with invalid parameter
    Given Put Single product with invalid json "PutSingleProduct.json" and user id 1
    When Send request put single product
    Then Status code should be 404 oK
    And Response body put single should be 1
    And Validate put single product JSON schema "PutSingleProductSchema.json"