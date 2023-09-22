package starter.Dummy;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class DeleteProductAPI {
    public static String DELETE_PRODUCTS = Constants.BASE_URL+"/products/{id}";
    @Step("Delete Product")
    public void DeleteProduct(int id) {
        SerenityRest.given()
                .pathParam("id", id);

    }
}
