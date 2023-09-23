package starter.dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DeleteACart {
    public static String DELETE_CART = Constants.BASE_URL+"/carts/{id}";

    @Step("Delete cart")
    public void setDeleteCart(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
