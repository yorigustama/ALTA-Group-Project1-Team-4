package starter.dummyjson;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetListUser {
    public static String GET_LIST_USER = Constants.BASE_URL+"/user";

    @Step("Get list user")
    public void setGetListUser(){
        SerenityRest.given();

    }

}
