package reqres.api.Example;

import static io.restassured.RestAssured.*; //instead of import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_1(){
        //Run a GET request
        Response response = get("https://reqres.in/api/users?page=2");

        //Store response and print response data
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        //Add assertions

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200); //actual, expected

    }

    @Test
    public void test_2() {

        baseURI="https://reqres.in/api"; //or given().get("https://reqres.in/api/users?page=2");
        given().get("/users?page=2").then().statusCode(200)
                .body("data[1].id", equalTo(8))
                .log().all();

    }
}
