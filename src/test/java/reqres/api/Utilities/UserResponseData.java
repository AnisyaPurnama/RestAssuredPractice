package reqres.api.Utilities;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserResponseData {
    public static final String DATA = "DATA";
    public static final String CREATED_USER = "CREATED USER";
    public static final String USER_UPDATED = "USER UPDATED";
    public static final String USER_PARTIAL_UPDATE = "USER PARTIAL UPDATED";



    public void containData(String statusCode, JSONObject request) {
        switch (statusCode) {
            case DATA:
                given()
                        .when()
                        .get("/users?page=2")
                        .then()
                        .statusCode(200)
                        .body("data[4].first_name", equalTo("George"))
                        .body("data.first_name", hasItems("George", "Rachel"));
                //System.out.println(response.asString());
                break;
            case CREATED_USER:
                assert request.get("name").equals("Ani Weet");
                assert request.get("job").equals("QA Engineer");

                System.out.println(request.toJSONString());
                break;
                //TODO
            case USER_UPDATED:
                break;
            case USER_PARTIAL_UPDATE:
            default:
                break;
        }
        if (request != null) {
            assert request.get("name").equals("Ani Weet");
            assert request.get("job").equals("QA Engineer");

            System.out.println(request.toJSONString());
        }
    }
}
