package Files;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test
    public void addBook()
    {
        RestAssured.baseURI="http://216.10.245.166";
        String response=given().log().all().header("Content-Type","text/plain").body(payloads.addBook())
                .when().post("Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js= new JsonPath(response);
        String aisle=js.getString("Msg");
        System.out.println(aisle);
    }
}
