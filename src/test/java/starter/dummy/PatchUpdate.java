package starter.dummy;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PatchUpdate {
    public static String PATCH_UPDATE = Constants.BASE_URL+"/carts/{id}";

    @Step("Patch update")
    public void setPatchUpdate(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
