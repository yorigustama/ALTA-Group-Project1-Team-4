package starter.stepdef;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.PostCreateNewUser;
import starter.utils.Constants;

import java.io.File;

public class PostCreateNewUserStepDef {
    @Steps
    PostCreateNewUser postCreateNewUser;
    @Given("Create new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POST_CREATE_NEW_USER+jsonFile);
        postCreateNewUser.setPostCreateUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(PostCreateNewUser.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);

    }

    @And("Validate post create JSON schema {string}")
    public void validatePostCreateJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
