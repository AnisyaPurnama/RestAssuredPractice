package reqres.api.Requests;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class Delete {
    @Test
    public void deleteRequest() {
        baseURI = "https://reqres.in";
        when()
                .delete("/api/user/2");
    }
}
