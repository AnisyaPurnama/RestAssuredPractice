package reqres.api.Pages;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ListUser {
    @Test
    public void getUser() {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2");
    }
}
