package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {

        /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void test01() {

        // 1. Step Set the Url

        spec.pathParam("first","todos");

        // 2. Step set the Expected data

        JsonPlaceHolderPojo requesrBody=new JsonPlaceHolderPojo(55,"Tidy your room",false);

        // 3. Step Send Post Request and the Response

        Response response=given().spec(spec.contentType(ContentType.JSON)).body(requesrBody).when().post("/{first}");
        response.prettyPrint();


        // 4. Step Do Assert

        JsonPlaceHolderPojo actualBody=response.as(JsonPlaceHolderPojo.class);
// response JsonPlaceHolderPojo data formatina ceviriyoruz

        Assert.assertEquals(requesrBody.getUserId(),actualBody.getUserId());
        Assert.assertEquals(requesrBody.getCompleted(),actualBody.getCompleted());
        Assert.assertEquals(requesrBody.getTitle(),actualBody.getTitle());

        Assert.assertEquals(requesrBody.toString(),actualBody.toString());

        System.out.println("requesrBody.toString() = " + requesrBody.toString());

        System.out.println("actualBody.toString() = " + actualBody.toString());


    }
}
