package put_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_date.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonPlaceHolderBaseUrl {

     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void test01() {

        // 1. Step Set the Url
        spec.pathParams("first", "todos", "second", 198);

        // 2. Step set the expected data

        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();

        Map<String, Object> expectedDataMap =
                expectedData.expectedDataWithAllKeys(21, "Wash the dishes", false);

        //3. Step Send the put request

        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expectedDataMap).when().put("/{first}/{second}");

        response.prettyPrint();

      // 4. Step DO Assertion

        Map<String,Object> actualDataMap=response.as(HashMap.class);

        Assert.assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        Assert.assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));

    }
}