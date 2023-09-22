package starter.Dummy;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostAddProductAPI {
    public static String POST_ADD_PRODUCT = Constants.BASE_URL+"/products/add";

    @Step("Post Add Product")
    public void postAddProduct(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
