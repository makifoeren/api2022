package utils;



import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    //1. Method: Json Datasını Java Objesine çevirir.(De-Serialization)
// T -->key
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls){
        //Generic Method --> her turlu data tipi ile calisan
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json,cls); //json datayi okuyup istenilen clas ta ver
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }


    //2. Method: Java Objesini Json Dataya  çevirir.(Serialization)

    public static String convertJavaObjectToJson(Object obj){

        String jsonResult = null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
