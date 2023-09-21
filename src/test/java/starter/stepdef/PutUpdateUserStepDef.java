package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.PutUpdateUser;
import starter.utils.Constants;

import java.io.File;

public class PutUpdateUserStepDef {
    @Steps
    PutUpdateUser putUpdateUser;
    @Given("Update user with json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_POST_CREATE_NEW_USER+jsonFile);
        putUpdateUser.setPutUpdateUser(json, id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(PutUpdateUser.PUT_UPDATE_USER);
    }
}
