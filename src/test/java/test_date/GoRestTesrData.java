package test_date;

import java.util.HashMap;
import java.util.Map;

public class GoRestTesrData {

    public Map<String, String > dataKeyMap(String name, String email, String gender, String status){
        Map<String, String> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("email", email);
        dataKeyMap.put("gender", gender);
        dataKeyMap.put("status", status);

        return dataKeyMap;
    }

    public Map<String, Object> expectedDateMap(Object meta, Map<String, String > data){

        Map<String, Object> expectedDate=new HashMap<>();
        expectedDate.put("meta", meta);
        expectedDate.put("data", data);

return expectedDate;
    }
}
