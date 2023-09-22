package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DummyResponse;
import starter.dummy.GetCartOfUser;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetCartOfUserStepdef {

    @Steps
    GetCartOfUser getCartOfUser;
    @Given("Get cart of user valid parameter id {int}")
    public void getCartOfUserValidParameterId(int id) {
        getCartOfUser.setGetCartUser(id);
    }

    @When("Send request get cart of user")
    public void sendRequestGetCartOfUser() {
        SerenityRest.when().get(GetCartOfUser.GET_CART_USER);
    }

    @And("Response cart user body page should id {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(DummyResponse.ID, equalTo(page));
    }

    @And("Validate get cart of user JSON schema {string}")
    public void validateGetCartOfUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get cart of user with parameter page {int}")
    public void getCartOfUserWithParameterPage(int page) {
        getCartOfUser.setGetCartUser(page);
    }
}
