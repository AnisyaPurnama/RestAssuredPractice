package reqres.api.Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import reqres.api.Utilities.ResponseValidator;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Register {
    ResponseValidator responseValidator = new ResponseValidator();
    @Before
    public void toRegistrationPage() {
        baseURI="https://reqres.in/api/register";
    }

    @Test
    public void enterValidDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put ("password", "pistol");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";

        Response response = given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/register");
        validateUserRegistered(response);
    }

    public void validateUserRegistered(Response response) {
        response.then()
                .statusCode(200)
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .log().all();
    }

    @Test
    public void enterInvalidDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("email", "sydney@fife");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";

        Response response = given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/register");
        responseValidator.errorMessage(response);
    }
}
