package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.GetListUser;

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
}
