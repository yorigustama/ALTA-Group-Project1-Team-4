package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Dummy.DeleteProductAPI;
import starter.Dummy.DummyResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteProductStepDef {
    @Steps
    DeleteProductAPI deleteProductAPI;
    @Given("Delete a product with valid user id {int}")
    public void deleteAProductWithValidUserId(int id) {
        deleteProductAPI.DeleteProduct(id);
    }
    @When("Send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(DeleteProductAPI.DELETE_PRODUCTS);
    }

    @Then("Status code delete should be {int}")
    public void statusCodeDeleteShouldBe(int ok) {
        SerenityRest.then().statusCode(ok);
    }


    @And("Response body delete product should be {int}")
    public void responseBodyDeleteProductShouldBe(int id) {
        SerenityRest.and().body(DummyResponses.ID,equalTo(id));
    }

    @And("Validate delete product JSON schema {string}")
    public void validateDeleteProductJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete a product with invalid user id {int}")
    public void deleteAProductWithInvalidUserId(int id) {
        deleteProductAPI.DeleteProduct(id);
    }
}
