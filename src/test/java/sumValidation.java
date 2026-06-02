import Files.payloads;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sumValidation
{
    @Test
    public void sumOfCources()
    {
        int sum=0;
        JsonPath js = new JsonPath(payloads.CoursePrice());
        int count= js.getInt("courses.size()");
        for (int i=0; i<count;i++)
        {
            int price=js.getInt("courses["+i+"].price");
            int copies=js.getInt("courses["+i+"].copies");
            int amount=price * copies;
            System.out.println(amount);
            sum=sum+amount;

        }
        System.out.println(sum);
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(purchaseAmount,sum);
        System.out.println("Items matched");
    }

}
