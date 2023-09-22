package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Dummy.DummyResponses;
import starter.Dummy.PutSingleProductAPI;
import starter.utils.Constants;



import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PutSingleProduct {
    @Steps
    PutSingleProductAPI putSingleProductAPI;

    @Given("Put Single product with valid json {string} and user id {int}")
    public void putSingleProductWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        putSingleProductAPI.putSingleProduct(json, id);
    }

    @When("Send request put single product")
    public void sendRequestPutSingleProduct() {
        SerenityRest.when().put(PutSingleProductAPI.PUT_SINGLE_PRODUCT);
    }

    @Then("Status code should be {int} oK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body put single should be {int}")
    public void responseBodyPutSingleShouldBe(int id) {
        SerenityRest.and().body(DummyResponses.ID,equalTo(id));
    }

    @And("Validate put single product JSON schema {string}")
    public void validatePutSingleProductJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put Single product with invalid json {string} and user id {int}")
    public void putSingleProductWithInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        putSingleProductAPI.putSingleProduct(json, id);
    }
}
