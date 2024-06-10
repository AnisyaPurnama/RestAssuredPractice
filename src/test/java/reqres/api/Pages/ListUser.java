package reqres.api.Pages;

import io.cucumber.junit.CucumberOptions;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class ListUser {
    @Test
    public void getUser(String endpoint) {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2");
    }

    public void responseStatus() {
        given().then().statusCode(200);
    }

    public void containData() {
        given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name", hasItems("George", "Rachel"));
    }

}
