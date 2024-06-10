package reqres.api.Pages;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateUser {

    public void postUser (){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("name", "Ani Weet");
        request.put ("job", "QA Engineer");
        System.out.println(request.toJSONString());
    }
}
