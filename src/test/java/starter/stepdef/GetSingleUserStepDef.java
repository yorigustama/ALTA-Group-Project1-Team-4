package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.DummyJsonResponses;
import starter.dummyjson.GetSingleUser;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {

    @Steps
    GetSingleUser getSingleUser;
    @Given("Get single user with parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        getSingleUser.setGetListSingleUser(id);

    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleUser.GET_LIST_SINGLE_USER);
    }


    @And("Respon single user body page should id {int}")
    public void responSingleUserBodyPageShouldId(int page) {
        SerenityRest.and().body(DummyJsonResponses.DATA_ID,equalTo(page));
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeBadReques(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
