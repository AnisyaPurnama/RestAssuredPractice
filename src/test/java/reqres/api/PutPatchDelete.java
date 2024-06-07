package reqres.api;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {
    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "ani");
        request.put("job", "Teacher");

        System.out.println(request.toJSONString()); //output convert to json string
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

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "ani");
        request.put("job", "Teacher");

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

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in";
                 when()
                .delete("/api/user/2") //endpoint
                .then()
                .statusCode(204).log().all();
    }
}
