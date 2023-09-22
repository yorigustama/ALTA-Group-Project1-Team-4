package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DummyResponse;
import starter.dummy.PostAddNewCart;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostAddNewCartStepdef {

    @Steps
    PostAddNewCart postAddNewCart;
    @Given("Add new cart with json {string}")
    public void addNewCartWithJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POST+jsonFile);
        postAddNewCart.setPostAddNewCart(json);
    }

    @When("Send request post add new cart")
    public void sendRequestPostAddNewCart() {
        SerenityRest.when().post(PostAddNewCart.POST_ADD_NEW_CART);
    }

    @And("Respon add cart body page should id {int}")
    public void responAddCartBodyPageShouldId(int page) {
        SerenityRest.then().body(DummyResponse.ID, equalTo(page));
    }

    @And("Validate post add cart JSON schema {string}")
    public void validatePostAddCartJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
