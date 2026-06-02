import Files.payloads;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class Basics {
    public static void main(String[] args)
    {
        baseURI ="https://rahulshettyacademy.com";

        //given - all input details
        //when - Submit the API -resource,http method
        //Then - validate the response


        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payloads.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .extract().response().asString();


        //System.out.println(response);

        JsonPath js= new JsonPath(response);
        String placeID=js.getString("place_id");
        System.out.println(placeID);

        String newAddress = "Summer Park, Chandigarh, India";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\": \""+placeID+"\",\n" +
                        "\"address\": \""+newAddress+"\",\n" +
                        "\"key\": \"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));



        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1= new JsonPath(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);






    }

}
