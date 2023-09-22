package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DummyResponse;
import starter.dummy.GetAllCart;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllCartStepdef {
    @Steps
    GetAllCart getAllCart;
    @Given("Get all cart with valid parameter")
    public void getAllCartWithValidParameter() {
        getAllCart.setGetAllCart();
    }

    @When("Send request get all cart")
    public void sendRequestGetAllCart() {
        SerenityRest.when().get(GetAllCart.GET_ALL_CART);
    }

    @And("Response all cart body page should be {int}")
    public void responseAllCartBodyPageShouldId(int id) {
        SerenityRest.then().body(DummyResponse.PAGE, equalTo(id));
    }

}
