Feature: PROJECT TEAM 4 PRODUCT
  @Tugas
#  Positive Case
  Scenario: Post Add Product with valid json
    Given Add Product with valid json "PostAddProduct.json"
    When Send request post add product
    Then Status code should be 200 Created
    And Response body id was 101 and title was "BMW Pencil"
    And Validate post add product JSON schema "PostAddProductSchema.json"

    #  Negative Case
  @Tugas
  Scenario: Post Add Product with invalid json
    Given Add Product with invalid json "PostAddProduct.json"
    When Send request post add product
    Then Status code should be 404 Created
    And Response body id was 101 and title was "BMW Pencil"
    And Validate post add product JSON schema "PostAddProductSchema.json"