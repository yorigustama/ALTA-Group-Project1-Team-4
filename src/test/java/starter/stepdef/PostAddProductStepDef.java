package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Dummy.DummyResponses;
import starter.Dummy.PostAddProductAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostAddProductStepDef {
    @Steps
    PostAddProductAPI postAddProductAPI;
    @Given("Add Product with valid json {string}")
    public void addProductWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postAddProductAPI.postAddProduct(json);
    }
    @When("Send request post add product")
    public void sendRequestPostAddProduct() {
        SerenityRest.when().post(PostAddProductAPI.POST_ADD_PRODUCT);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("Response body id was {int} and title was {string}")
    public void responseBodyIdWasAndTitleWas(int id, String title) {
        SerenityRest.and().body(DummyResponses.ID,equalTo(id));
        SerenityRest.and().body(DummyResponses.TITLE,equalTo(title));
    }
    @And("Validate post add product JSON schema {string}")
    public void validatePostAddProductJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Add Product with invalid json {string}")
    public void addProductWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        postAddProductAPI.postAddProduct(json);

    }
}
