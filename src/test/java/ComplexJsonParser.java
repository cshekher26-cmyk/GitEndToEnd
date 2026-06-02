import Files.payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParser
{
public static void main (String[] args)
{
    JsonPath js=new JsonPath(payloads.CoursePrice());
    int count = js.getInt("courses.size()");
    System.out.println(count);

    int purchaseAmount= js.getInt("dashboard.purchaseAmount");
    System.out.println(purchaseAmount);

    String title=js.get("courses[1].title");
    System.out.println(title);

    for (int i=0; i<count; i++) {
        String CourseName = js.getString("courses[" + i + "].title");
        System.out.println("Course Name: " + CourseName);


        //int CoursePrice = js.getInt("courses[" + i + "].price");
        //System.out.println("Price:" + CoursePrice);
        System.out.println(js.getInt("courses["+i+"].price"));
    }

    System.out.println("print sold copies of RPA");

    for (int j=0; j<count; j++)
    {
        String CourseName = js.getString("courses[" + j + "].title");

        if(CourseName.equalsIgnoreCase("RPA"))
        {
            System.out.println(js.getString("courses[" + j + "].copies"));
            break;
        }

    }


}


}
