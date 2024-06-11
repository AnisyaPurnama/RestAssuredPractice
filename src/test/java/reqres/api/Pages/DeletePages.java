package reqres.api.Pages;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class DeletePages {
    @Test
    public void deleteRequest() {
        baseURI = "https://reqres.in";
        when()
                .delete("/api/user/2");
    }
}
