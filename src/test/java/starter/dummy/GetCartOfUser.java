package starter.dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetCartOfUser {
    public static String GET_CART_USER = Constants.BASE_URL + "/carts/user/{id}";

    @Step("Get cart of user")
    public void setGetCartUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
