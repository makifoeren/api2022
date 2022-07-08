package get_requests;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class Get01 {


    @Test
    public void test01() {

        //Given
        //            https://restful-booker.herokuapp.com/booking/3
        //        When
        // ..           User sends a GET Request to the url
        // i) Set the URL

        String url = "https://restful-booker.herokuapp.com/booking";

        // ii) Set the expected data(POST-PUT-PATCH)

        // iii) Type code to send request (POST-PUT-PATCH)

        Response response = given().when().get(url);

        // response.prettyPeek();
        // response.prettyPrint();

        // iii) Do Assertion


        //        Then
        //            HTTP Status Code should be 200
        //        And
        //            Content Type should be JSON
        //        And
        //            Status Line should be HTTP/1.1 200 OK

        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

        // status code nasil yazdirilir

        System.out.println("Status Code = " + response.statusCode());

        // Content Type nasil yazdirilir

        System.out.println("Content Type : " + response.contentType());

        // Status Line nasil yazdirilir

        System.out.println("Status Line : " + response.statusLine());


        // Header nasil yazdirilir

        //System.out.println(response.header("Connetion"));
        //System.out.println(response.header("User-Agent"));

        // Headers nasil yazdirilir

        System.out.println("Headers :\n" + response.headers());

        // Time nasil yazdirilir

        System.out.println("response.getTime() = " + response.getTime());

    }
}
