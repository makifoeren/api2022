package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 {

    /*  Given
1-           https://restful-booker.herokuapp.com/booking/1005

         When
 3-                 User send a GET Request to the url

        Then
 4-          HTTP Status code should be 404
        And
   4-         Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void test01() {



        // 1. Step : Set the Url
        String url="https://restful-booker.herokuapp.com/booking/1005";


        // 2. Step:  Set tehe expected data(Post - Put - Patch)

        // 3.Step : Type code to send requerst

        Response response=given().when().get(url);

        response.prettyPrint();

        // 4. Step : Do Assertion
// asserThat hepsi bir arada yaparken
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Response body de bulunan spesifik bir veri nasil assert edilir

        Assert.assertTrue(response.asString().contains("Not Found")); ;

        // Response body de  spesifik bir veri bulunmadigi nasil assert edilir


        Assert.assertFalse(response.asString().contains("TechProEd"));

        Assert.assertEquals("Cowboy",response.header("Server"));
    }
}
