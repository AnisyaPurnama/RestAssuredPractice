package reqres.api.Pages;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UpdatePages {
    @Test
    public void putUpdateUser() {
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/user/2") //endpoint
                .then()
                .statusCode(200).log().all();
    }

    public void patchUpdateUser() {
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        System.out.println(request.toJSONString()); //output convert to json string
        baseURI = "https://reqres.in";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/api/user/2") //endpoint
                .then()
                .statusCode(200).log().all();
    }

}

