package getRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get11 extends GoRestApiBaseURL {
  /*


        Given
            https://gorest.co.in/public/v2/users/7511416
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this

                {
        "id": 7511416,
        "name": "Msgr. Chaturbhuj Bhat",
        "email": "bhat_msgr_chaturbhuj@skiles.example",
        "gender": "female",
        "status": "active"
    }

  */

    @Test
    public void get11(){

        //Set the URL
        specification.pathParams("usersPath", "users", "idPath", "7511416");

        //Set the expected Data
        String expectedData= "  {\n" +
                "        \"id\": 7511416,\n" +
                "        \"name\": \"Msgr. Chaturbhuj Bhat\",\n" +
                "        \"email\": \"bhat_msgr_chaturbhuj@skiles.example\",\n" +
                "        \"gender\": \"female\",\n" +
                "        \"status\": \"active\"\n" +
                "    }";
        System.out.println("expectedData = " + expectedData);


        /*
        Object Mapper-->

        Verilen String degerlerini/Json datası formatında olsa bile Map formatında bir dataya donusturmenizi saglayan bir kutuphanedir.
        Object Mapper Kullanbilmek icin pom.xml file da bir depedency gereklidir

         */

        GoRestApiPojo goRestApiPojo=  JsonToJava.convertJsonToJavaObject(expectedData, GoRestApiPojo.class);

        System.out.println("goRestApiPojo = " + goRestApiPojo);

        HashMap<String, Object>  expectedDataMap= JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        System.out.println("expectedDataMap = " + expectedDataMap);

        //Send the request

        Response response=  given().spec(specification).when().get("/{usersPath}/{idPath}");
        response.prettyPrint();

        //Do the assertion

       HashMap<String, Object> actualDataMap= JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("id"), actualDataMap.get("id"));
        assertEquals(expectedDataMap, actualDataMap);




    }


}
