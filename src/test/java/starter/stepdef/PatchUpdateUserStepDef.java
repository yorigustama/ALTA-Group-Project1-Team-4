package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyJsonResponses;
import starter.dummyjson.PatchUpdateUser;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PatchUpdateUserStepDef {

    @Steps
    PatchUpdateUser patchUpdateUser;
    @Given("Update user patch with json {string} and user id {int}")
    public void updateUserPatchWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_POST_CREATE_NEW_USER + jsonFile);
        patchUpdateUser.setPatchUpdateUser(json, id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(PatchUpdateUser.PATCH_UPDATE_USER);
    }

    @And("Respon body patch firstName was {string} and lastName was {string}")
    public void responBodyPatchNameWasAndJobWas(String firstName, String lastName) {
        SerenityRest.and().body(DummyJsonResponses.FIRST_NAME, equalTo(firstName));
        SerenityRest.and().body(DummyJsonResponses.LAST_NAME, equalTo(lastName));
    }
}
