import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrls {


    public RequestSpecification spec;

    // @Before her test methodundan önce calisir
    @Before
    public void setUp(){

        spec= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
