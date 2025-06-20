package reqres.api.Utilities;

import org.json.simple.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserResponseData {
    public static final String DATA = "DATA";
    public static final String CREATED_USER = "CREATED USER";
    public static final String USER_UPDATED = "USER UPDATED";
    public static final String USER_PARTIAL_UPDATE = "USER PARTIAL UPDATED";


    public void containData(String statusCode, JSONObject request) {
        if (statusCode != null) {
            switch (statusCode) {
                case DATA:
                    verifyDataResponse("/users?page=2", "George", "Rachel");
                    break;
                case CREATED_USER:
                    verifyCreatedUser(request, "Ani Weet", "QA Engineer");
                    break;
                //TODO
                case USER_UPDATED:
                    break;
                case USER_PARTIAL_UPDATE:
                default:
                    break;
            }
        }
    }

    public void verifyDataResponse(String endpoint, String... expectedFirstNames) {
        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("data.first_name", hasItems(expectedFirstNames));
    }

    public void verifyCreatedUser(JSONObject request, String expectedName, String expectedJob) {
        Assert.assertEquals(expectedName, request.get("name"));
        Assert.assertEquals(expectedJob, request.get("job"));
    }
}

