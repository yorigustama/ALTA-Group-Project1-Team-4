package starter.Dummy;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PutSingleProductAPI {
    public static String PUT_SINGLE_PRODUCT = Constants.BASE_URL+"/products/{id}";

    @Step("Put Single Product")
    public void putSingleProduct(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }
}
