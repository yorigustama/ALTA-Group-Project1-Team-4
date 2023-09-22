package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.dummy.DeleteACart;

public class DeleteCartStepdef {

    @Steps
    DeleteACart deleteACart;
    @Given("Delete a cart without user id {int}")
    public void deleteACartWithoutUserId(int id) {
        deleteACart.setDeleteCart(id);
    }

    @When("Send request delete cart")
    public void sendRequestDeleteCart() {
        SerenityRest.when().delete(DeleteACart.DELETE_CART);
    }
}
