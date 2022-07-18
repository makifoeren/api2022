package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_date.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Patch01 extends JsonPlaceHolderBaseUrl {

     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url  Yama verilerin bir kisimi gonderiliryor ve degistiriyor
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */

    @Test
    public void test01() {
        // 1. Step Set the Url

        spec.pathParams("first","todos","second",198);

        // 2. Step Set the Request Body

        JsonPlaceHolderTestData requestBody=new JsonPlaceHolderTestData();
        // Map<String,Object> requestBodyMap= requestBody.expectedDataWithAllKeys(10,"Wash the dishes",true);
        //  bu methodla hepsi ni degistiriyor test geciyor fakt istenilen degil
        // 2. method olusturuldu

        Map<String,Object> requestBodyMap= requestBody.
                expectedDataWithMissingAllKeys(null,"Wash the dishes",null);
      // 3. Step Send the Patch request get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(requestBodyMap).when().patch("/{first}/{second}");

        response.prettyPrint();

        // 4. Step Do Assertion
        Map<String,Object> actualDataMap=response.as(HashMap.class);

       // Map<String,Object> mapToAssertAllDetails =
         //       requestBody.expectedDataWithAllKeys(10,"Wash the dishes",true);

        //response.then().assertThat().statusCode(200).body("title",equalTo(actualDataMap.get("title")),
          //      "userId",equalTo(actualDataMap.get("userId")),
            //    "completed",equalTo(actualDataMap.get("completed")));


        Assert.assertEquals(requestBodyMap.get("title"),actualDataMap.get("title"));



    }
}
