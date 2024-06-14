package reqres.api.Utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseValidator {
    public static final String OK = "OK";
    public static final String CREATED = "CREATED";
    public static final String NO_CONTENT = "NO CONTENT";


    public void getResponseStatus(String statusCode) {
        switch (statusCode) {
            case OK:
                given().then().statusCode(200);
                break;
            case CREATED:
                given().then().statusCode(201);
                break;
            case NO_CONTENT:
                given().then().statusCode(204);
            default:
                break;
        }
    }

    public void errorMessage(Response response) {
        response.then()
                .statusCode(400)
                .body("error", equalTo("Missing password"))
                .log().all();
    }
}
