package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
     "firstname": "Marcus",
    "lastname": "Thomsen",
    "totalprice": 717,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-11",
        "checkout": "2022-07-12"
    },
    "additionalneeds": "Late Checkout"
}
     */

    @Test
    public void test01() {

        // 1. Step: Set the Url

        spec.pathParams("first", "booking", "second", 101);
        //2. Set the expected data

        //3. Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Step Do Assert

        response.
                then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Marcus"),
                        "lastname", equalTo("Thomsen"),
                        "totalprince", equalTo(717),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2022-07-11"),
                        "bookingdates.checkout", equalTo("2022-07-12"));


        // 2. yol JsonPath Class kullanilir

        JsonPath json = response.jsonPath();

        Assert.assertEquals("Marcus", json.getString("firstname"));
        Assert.assertEquals("Thomsen", json.getString("lastname"));
        Assert.assertEquals(true, json.getBoolean("depositpaid"));
        Assert.assertEquals("2022-07-11", json.getString("bookingdates.checkin"));
        Assert.assertEquals("2022-07-12", json.getString("bookingdates.checkout"));
        Assert.assertEquals(717, json.getInt("totalprice"));
        Assert.assertEquals("Late Checkout", json.getInt("additionalneeds"));


        // 3.yol soft assertion
        // Soft Assertion icin 3 adim izlenir

        // 1) Soft Assert obj si olusturulur

        SoftAssert softAssert = new SoftAssert();

        // 2) obje araciligi ile assert yapilir

        softAssert.assertEquals(json.getString("firstname"), "Marcus", "firstname uyuşmadı");
        softAssert.assertEquals(json.getString("lastname"), "Thomsen", "lastname uyuşmadı");
        softAssert.assertEquals(json.getInt("totalprice"), 717, "totalprice uyuşmadı");
        softAssert.assertEquals(json.getBoolean("depositpaid"), true, "depositpaid uyuşmadı");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2022-07-11", "checkin uyuşmadı");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2022-07-12", "checkout uyuşmadı");
        softAssert.assertEquals(json.getString("additionalneeds"), "Late Checkout", "uyusmadi");

        // 3) assertAll() kullanilir aksi takdirde kodumuz calidmaz assert islemei calismaz, herzaman pass olur
        softAssert.assertAll();


    }
}