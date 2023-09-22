package starter.dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetSingleCartAPI {
    public static String GET_SINGLE_CART = Constants.BASE_URL + "/carts/{id}";
    public static String GET_SINGLE_CART_NOT_FOUND =Constants.BASE_URL + "/carts/{id}";

    @Step("Get single cart")
    public void getSingleCart(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
