package reqres.api.Example;

import io.restassured.http.ContentType;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAndPost {
    //@Test
    public void testGet() {
        baseURI="https://reqres.in/api";
        given().get("/users?page=2")
                .then().statusCode(200)
                .body("data[4].first_name", equalTo("George"))
                .body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String, Object>();
                /*map.put("name", "ani");
                map.put("job", "Teacher");
                System.out.println(map);*/

        JSONObject request = new JSONObject();
        request.put("name", "ani");
        request.put ("job", "Teacher");
        System.out.println(request.toJSONString()); //output convert to json string
        baseURI="https://reqres.in/api";

        given().body(request.toJSONString())
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("/user") //endpoint
                .then()
                .statusCode(201).log().all();
    }
}
