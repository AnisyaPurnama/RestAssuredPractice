package reqres.api.Requests;

import org.json.simple.JSONObject;
import org.junit.Test;
import reqres.api.Utilities.UserResponseData;

import java.util.HashMap;
import java.util.Map;

public class CreateUser {
@Test
    public void postUser (){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("name", "Ani Weet");
        request.put ("job", "QA Engineer");
        System.out.println(request.toJSONString());

    UserResponseData userResponseData = new UserResponseData();
    userResponseData.containData("CREATED USER", request);
    System.out.println(request.toJSONString());
    }

}
