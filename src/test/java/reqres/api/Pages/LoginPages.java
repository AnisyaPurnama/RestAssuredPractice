package reqres.api.Pages;

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
import static org.hamcrest.Matchers.equalTo;

public class LoginPages {
    ResponseValidator responseValidator = new ResponseValidator();
    @Before
    public void toLoginPage() {
        baseURI="https://reqres.in/api/login";
    }

    @Test
    public void enterValidUsername() {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        //request.put ("password", "pistol");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";

        Response response = given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/login");
    }

    public void enterValidPassword() {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put ("password", "cityslicka");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";

        Response response = given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/login");
        validateLoggedIn(response);
    }

    public void validateLoggedIn(Response response) {
        response.then()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .log().all();
    }

    public void enterInvalidUsername() {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put ("email", "peter@klaven");
        System.out.println(request.toJSONString());
        baseURI="https://reqres.in/api";

        Response response = given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/login");
        responseValidator.errorMessage(response);
    }
}
