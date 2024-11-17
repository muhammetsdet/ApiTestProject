package getRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13 extends JsonPlaceHolderBaseURL {
     /*
       Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */

@Test
    public void testGet13() {

    specification.pathParams("usersPath", "todos", "idPath", "198");

    //Set the expectd Daata

    String expectedData = " {\n" +
            "\t\t\t\t\t\t\t\t\t    \"userId\": 10,\n" +
            "\t\t\t\t\t\t\t\t\t    \"id\": 198,\n" +
            "\t\t\t\t\t\t\t\t\t    \"title\": \"quis eius est sint explicabo\",\n" +
            "\t\t\t\t\t\t\t\t\t    \"completed\": true\n" +
            "\t\t\t\t\t\t\t\t\t  }";

    System.out.println("expectedData = " + expectedData);

    HashMap<String, Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
    System.out.println("expectedDataMap = " + expectedDataMap);

    Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");
    response.prettyPrint();

    HashMap<String, Object> actualDataMap = response.as(HashMap.class);
    System.out.println("actualDataMap= " + actualDataMap);

    JsonPath jsonPath = response.jsonPath();
    jsonPath.prettyPrint();

   HashMap<String,Object> actualDataMapJsonToJava= JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
    System.out.println("actualDataMapJsonToJava = " + actualDataMapJsonToJava);

    //Assertion
    assertEquals(expectedDataMap,actualDataMapJsonToJava);






}
}
