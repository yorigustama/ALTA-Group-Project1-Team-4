package starter.dummyjson;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostCreateNewUser {
    public static String POST_CREATE_USER = Constants.BASE_URL+"/users/add";

    @Step("Post crate new user")
    public void setPostCreateUser(File json){
        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}

