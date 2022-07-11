package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
     */

    @Test
    public void test01() {

        // 1. Step: Set the Url

        spec.pathParams("first","booking").
                queryParams("firstname","GGS","lastname","FINCH");

        // 2. Step set the expected data

        //3. Step Send the request get the reponse
        Response response=given().when().spec(spec).get("/{first}");
        response.prettyPrint();


        // 4.Step Do Assert

        response.then().assertThat().statusCode(200);

        Assert.assertTrue(response.asString().contains("bookingid"));



    }

}