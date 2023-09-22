package starter.dummy;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostAddNewCart {
    public static String POST_ADD_NEW_CART = Constants.BASE_URL+"/carts/add";

    @Step("Post add new cart")
    public void setPostAddNewCart(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
