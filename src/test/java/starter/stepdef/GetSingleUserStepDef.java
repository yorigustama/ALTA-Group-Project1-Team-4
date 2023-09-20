package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.GetListUser;
import starter.dummyjson.GetSingleUser;

public class GetSingleUserStepDef {

    @Steps
    GetSingleUser getSingleUser;
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        getSingleUser.setGetListSingleUser(id);

    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleUser.GET_LIST_SINGLE_USER);
    }

//    @And("Respon single user body page should id {int}")
//    public void responSingleUserBodyPageShouldId(int arg0) {
//    }

}
