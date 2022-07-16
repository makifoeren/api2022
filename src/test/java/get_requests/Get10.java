package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_date.GoRestTesrData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
 {
    "meta": null,
    "data": {
        "id": 2965,
        "name": "Mr. Gita Menon",
        "email": "gita_menon_mr@bayer.com",
        "gender": "female",
        "status": "inactive""
             }
}     */

    @Test
    public void test01() {

        // 1.Step Set the Url

        spec.pathParams("first", "users", "second", 2965);

        // 2. Step Set the expected data
        GoRestTesrData dataKey = new GoRestTesrData();// gerekli methodun cagrilmasi icin obje olusturuyorum
        Map<String, String> dataKeyMap = // ic map olusuturoyrz
         dataKey.dataKeyMap("Mr. Gita Menon", "gita_menon_mr@bayer.com", "female", "inactive");

        Map<String, Object> expectedData = dataKey.expectedDateMap(null, dataKeyMap); // dis map olusturan method


        // 3.Step Send the request and GEt the Response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDateMap = response.as(HashMap.class);
        // De-Serialization ==> Json formatindan Java obj cevirme


        // 4.Step Do Assertion

        Assert.assertEquals(expectedData.get("meta"), actualDateMap.get("meta"));
        Assert.assertEquals(dataKeyMap.get("name"), ((Map) actualDateMap.get("data")).get("name"));
        Assert.assertEquals(dataKeyMap.get("email"), ((Map) actualDateMap.get("data")).get("email"));
        Assert.assertEquals(dataKeyMap.get("gender"), ((Map) actualDateMap.get("data")).get("gender"));
        Assert.assertEquals(dataKeyMap.get("status"), ((Map) actualDateMap.get("data")).get("status"));
//Actual data kismi Object, Map<String,Object>, goruldugu uzere 2. kisim hep object. o yuzden bu map olmadigi
        // icin casting yapiyoruz.

    }
}
