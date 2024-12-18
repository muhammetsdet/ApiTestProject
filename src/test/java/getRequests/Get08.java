package getRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseURL {

 /*
    Given
	   	     https://jsonplaceholder.typicode.com/todos/2
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"0,,,
        And
            Assert that the Server is cloudflare in the Header
        And
            Verify that the response body is like this


          {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
          }
 */
@Test
    public void get08(){

    specification.pathParams("todosPath","todos", "idPath",2);

    //Set "Expected data"
    JsonPlaceHolderTestData jsonData= new JsonPlaceHolderTestData();

    HashMap<String,Object> expectedData= jsonData.setUpDataTodos();

 //   System.out.println("expectedData = " + expectedData);
//Expected data Test Caseden veya Scenariodan gelir
    //Actual data Responsedan gelir

    //Send the request
  Response response= given().spec(specification).when().get("/{todosPath}/{idPath}");

  response.prettyPrint();

  //Do the assertion
//Diserialization
   HashMap<String, Object> actualData= response.as(HashMap.class);


   assertEquals(expectedData.get("StatusCode"), response.statusCode());
   assertEquals(expectedData.get("Server"), response.getHeader("Server"));
   assertEquals(expectedData.get("userId"), actualData.get("userId"));
   assertEquals(expectedData.get("id"), actualData.get("id"));
   assertEquals(expectedData.get("title"),actualData.get("title"));
   assertEquals(expectedData.get("completed"),actualData.get("completed"));


}


}
