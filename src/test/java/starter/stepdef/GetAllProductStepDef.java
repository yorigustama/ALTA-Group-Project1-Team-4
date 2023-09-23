package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Dummy.DummyResponses;
import starter.Dummy.GetAllProductAPI;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllProductStepDef {
    @Steps
    GetAllProductAPI getAllProductAPI;

    @Given("Get All Product with valid parameter page")
    public void getAllProductWithValidParameterPage() {
        getAllProductAPI.GetAllProduct();
    }
    @When("Send Request get all product")
    public void sendRequestGetAllProduct() {
        SerenityRest.when().get(GetAllProductAPI.GET_ALL_PRODUCT);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should be {}")
    public void responseBodyShouldBeId(int id) {
        SerenityRest.then()
                .body(DummyResponses.Data_ID_ARRAY,equalTo(id));
    }

    @And("Validate get list users JSON schema {string}")
    public void validateGetListUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get All Product with invalid parameter page")
    public void getAllProductWithInvalidParameterPage() {
        getAllProductAPI.GetAllProduct();
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }
}
