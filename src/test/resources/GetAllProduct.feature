Feature: PROJECT TEAM 4 PRODUCT
#  Positive Case
  @Tugas
  Scenario: Get All Product with valid parameter
    Given Get All Product with valid parameter page
    When Send Request get all product
    Then Status code should be 200 ok
    And Response body should be 1
    And Validate get list users JSON schema "GetAllProduct.json"

#  Negative Case
  Scenario: Get All Product with invalid parameter
    Given Get All Product with invalid parameter page
    When Send Request get all product
#    Then Status code should be 404 Not Found
    And Response body should be 1
    And Validate get list users JSON schema "GetAllProduct.json"
