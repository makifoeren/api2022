package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete01 extends JsonPlaceHolderBaseUrl {


     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

    @Test
    public void delete01(){
        //1. Step: Set the Url
        spec.pathParams("first", "todos","second",198);

        //2. Step: Set the expected data
        Map<String, Object> expectedDataMap = new HashMap<>();


        //3. Step: Send DELETE Request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();
        // contentype veri gonderildiginde yapilir silmede yapilmayabilir

        //4. Step: Do Assertion
        //1. Yol
        Map<String, Object> actualMap = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(expectedDataMap, actualMap);

        //2. Yol
        Assert.assertTrue(actualMap.size()==0);
        Assert.assertTrue(actualMap.isEmpty());//Tavsiye edilen

        //Delete request yapmadan önce "Post Request" yapıp o datayı silmeliyiz.

    }
}
