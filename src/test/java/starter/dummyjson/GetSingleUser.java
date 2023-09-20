package starter.dummyjson;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetSingleUser {
    public static String GET_LIST_SINGLE_USER = Constants.BASE_URL+("user/{id}");

    @Step("Get list single user")
    public void setGetListSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
