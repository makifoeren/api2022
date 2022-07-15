package get_requests;

import base_urls.AutomationExcer;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAuto extends AutomationExcer {
    @Test
    public void name() {


// 1. Step Set the Url
        //  String url=" https://automationexercise.com/api/productsList";

        spec.pathParams("first","api","second","productsList");

        // 2. Step Set the expected data (Post-Put-Petch)

        // 3.Step Send the requerst and get the Response
        Response response=given().when().spec(spec).accept(ContentType.JSON).get("/{first}/{second}");

        response.prettyPrint();


        // 4. Step Do Assertion

        //1. yol
        response.then().assertThat().statusCode(200).
                contentType("application/json");


    }
}