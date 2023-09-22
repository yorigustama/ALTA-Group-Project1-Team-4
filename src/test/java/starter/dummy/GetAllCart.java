package starter.dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetAllCart {
    public static String GET_ALL_CART = Constants.BASE_URL + "/carts";

    @Step("Get all cart")
    public void setGetAllCart(){
        SerenityRest.given();
    }
}
