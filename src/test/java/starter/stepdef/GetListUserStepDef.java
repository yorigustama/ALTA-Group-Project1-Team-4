package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyJsonResponses;
import starter.dummyjson.GetListUser;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUserStepDef {
    @Steps
    GetListUser getListUser;
    @Given("Get list user")
    public void getListUser() {
        getListUser.setGetListUser();
    }

    @When("Send request get list")
    public void sendRequestGetList() {
        SerenityRest.when().get(GetListUser.GET_LIST_USER);

    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }


    @Given("Get list user invalid parameter id {int}")
    public void getListUserInvalidParameterId(int id) {
        getListUser.setGetListUserInvalid(id);
    }

    @When("Send request get list invalid")
    public void sendRequestGetListInvalid() {
        SerenityRest.when().get(GetListUser.GET_LIST_USER_INVALID);
    }

//    @And("Response body page shoud be")
//    public void responseBodyPageShoudBe() {
//        SerenityRest.then().body(DummyJsonResponses.DATA_ID_ARRAY,equalTo());
//    }

    @And("Response body page shoud be {int}")
    public void responseBodyPageShoudBe(int page) {
        SerenityRest.then().body(DummyJsonResponses.DATA_ID_ARRAY,equalTo(page));
    }

    @Given("Get list user with paramater page {int}")
    public void getListUserWithParamaterPage(int page) {
        getListUser.setGetListUserInvalid(page);
    }

    @And("Validate get list user JSON schema {string}")
    public void validateGetListUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
}
