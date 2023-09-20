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

//    @Given("Get list user with valid parameter id {int}")
//    public void getListUserWithValidParameterId(int id) {
//        getListUser.setGetListUser(id);
//
//    }
    @Given("Get list user with valid parameter")
    public void getListUserWithValidParameter() {
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



}
