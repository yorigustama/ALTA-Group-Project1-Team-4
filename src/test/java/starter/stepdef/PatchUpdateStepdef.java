package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DummyResponse;
import starter.dummy.PatchUpdate;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PatchUpdateStepdef {

    @Steps
    PatchUpdate patchUpdate;
    @Given("Update user patch with valid json {string} and user id {int}")
    public void updateUserPatchWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY+jsonFile);
        patchUpdate.setPatchUpdate(json, id);
    }

    @When("Send request patch update cart")
    public void sendRequestPatchUpdateCart() {
        SerenityRest.when().patch(PatchUpdate.PATCH_UPDATE);
    }

    @And("Response body patch id was {int} and quantity was {int}")
    public void responseBodyPatchIdWasAndQuantityWas(int id, int quantity) {
        SerenityRest.and().body(DummyResponse.ID, equalTo(id));
        SerenityRest.and().body(DummyResponse.QUANTITY, equalTo(quantity));

    }

    @And("Validate patch update cart json schema {string}")
    public void validatePatchUpdateCartJsonSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
