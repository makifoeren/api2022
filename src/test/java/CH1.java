
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CH1 {


    @Test
    public void test01() {


        String urll = "https://restful-booker.herokuapp.com/booking/20297";

        Response res = given().when().get(urll);

        res.prettyPrint();


        System.out.println("res.statusCode() = " + res.statusCode());

        res.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK").header("Server", "Cowboy");


    }
}
