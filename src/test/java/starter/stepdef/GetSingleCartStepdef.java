package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DummyResponse;
import starter.dummy.GetSingleCartAPI;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleCartStepdef {

    @Steps
    GetSingleCartAPI getSingleCartAPI;

    @Given("Get single cart valid parameter id {int}")
    public void getSingleUserInvalidParameterId(int id) {
        getSingleCartAPI.getSingleCart(id);
    }

    @When("Send request get single cart")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleCartAPI.GET_SINGLE_CART);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBe(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @Given("Get single cart with parameter id {int}")
    public void getSingleCartWithParameterId(int id) {
        getSingleCartAPI.getSingleCart(id);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Response single cart body page should id {int}")
    public void responseSingleCartBodyPageShouldId(int page) {
        SerenityRest.then().body(DummyResponse.ID, equalTo(page));

    }

    @And("Validate get single cart JSON schema {string}")
    public void validateGetListUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
