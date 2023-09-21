package starter.Dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetAllProductAPI {
    public static String GET_ALL_PRODUCT = Constants.BASE_URL+"/products";

    @Step("Get All Product")
    public void  GetAllProduct() {
        SerenityRest.given();
    }
}
