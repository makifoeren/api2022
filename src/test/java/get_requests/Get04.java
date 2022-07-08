package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseUrl {

      /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void test01() {

        // 1. step set the url
        spec.pathParams("first", "todos");

        // 2. step set the excepted date

        //3.step set the request and get response

        Response response=given().when().spec(spec).accept(ContentType.JSON).get("/{first}");

        response.prettyPrint();

    }
}
