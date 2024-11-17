package getRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class Get12 extends GoRestApiBaseURL {
  /*


        Given
            https://gorest.co.in/public/v2/users/7527398
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this

               {
        "id": 7527398,
        "name": "Chandrakala Patil",
        "email": "chandrakala_patil@hegmann.example",
        "gender": "male",
        "status": "active"
    }
*/
@Test
    public void testGet12(){

    specification.pathParams("usersPath","users","idPath","7527398");

    GoRestApiPojo goRestApiPojoObj = new GoRestApiPojo("7527398","Chandrakala Patil","chandrakala_patil@hegmann.example", "male","active");

    System.out.println("goRestApiPojoObj = " + goRestApiPojoObj);

    Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");
    response.prettyPrint();

    GoRestApiPojo actualDataPojo = response.as(GoRestApiPojo.class);
    System.out.println("actualDataPojo = " + actualDataPojo);

    assertEquals(goRestApiPojoObj.getEmail(), actualDataPojo.getEmail());
    assertEquals(goRestApiPojoObj.getId(), actualDataPojo.getId());
    assertEquals(goRestApiPojoObj.getName(), actualDataPojo.getName());
    assertEquals(goRestApiPojoObj.getGender(), actualDataPojo.getGender());
    assertEquals(goRestApiPojoObj.getStatus(), actualDataPojo.getStatus());
    assertEquals(goRestApiPojoObj.getClass(), actualDataPojo.getClass());





}




}
