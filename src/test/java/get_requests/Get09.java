package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get09 extends HerOkuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/9
        When
            I send GET Request to the url
        Then
            Response body should be like that;

      "firstname": "UpdateFirstName",
    "lastname": "UpdateLastName",
    "totalprice": 50,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2021-11-01",
        "checkout": "2021-11-20"
    },
    "additionalneeds": "Breakfast"
     */

    @Test
    public void get01() {
        //1. Step: Set the Url
        spec.pathParams("first", "booking", "second", 9);

        //2. Step: Set the expected data

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2021-11-01");
        bookingdatesMap.put("checkout", "2021-11-20");

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname", "UpdateFirstName");
        expectedDataMap.put("lastname", "UpdateLastName");
        expectedDataMap.put("totalprice", 50);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingdatesMap);
        expectedDataMap.put("additionalneeds", "Breakfast");
        //expectedDataMap.put("checkin", "Breakfast");

        System.out.println(expectedDataMap);

        //3. Step: Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);


        //4. Step: Do Assertion

        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("additionalneeds"), actualDataMap.get("additionalneeds"));
      //  Assert.assertEquals(expectedDataMap.get("checkin"), actualDataMap.get("checkin"));

        Assert.assertEquals(bookingdatesMap.get("checkin"),  ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        Assert.assertEquals(bookingdatesMap.get("checkout"), ((Map) actualDataMap.get("bookingdates")).get("checkout"));

    }

}
