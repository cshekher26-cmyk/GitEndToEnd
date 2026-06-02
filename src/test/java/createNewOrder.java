import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class createNewOrder {
    @test
    public void createOrder()
    {
        RestAssured.baseURI="http://localhost:8080/mimo-order-management/secured/createNewOrder";
        given().header("Content-Type","application/json").body()
    }
}
