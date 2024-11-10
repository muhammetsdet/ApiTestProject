package getRequests;

import baseURL.ZippopotamBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippopotamPlacePojo;
import pojoDatas.ZippopotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get10 extends ZippopotamBaseURL {
    /*
     Given
            http://api.zippopotam.us/TR/34010
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this


    {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]
    }
     */

    @Test
    public void get10(){

        specification.pathParams("countryPath","TR", "postalCode","34010");

        //Set the expected date

        ZippopotamPlacePojo zippopotamPlacePojo = new ZippopotamPlacePojo
                ("Maltepe Mah.","32.3609","İstanbul","34","40.1589");

        ZippopotamPojos zippopotamPojos = new ZippopotamPojos ("34010", "Turkey", "TR",zippopotamPlacePojo);
        System.out.println("zippopotamPojos = " + zippopotamPojos);

        //Send the requeset
      Response response = given().spec(specification).when().get("/{countryPath}/{postalCode}");

      response.prettyPrint();

      //Do the assertion --> Deserialization --> GSON kullanarak

       Map<String,Object> actualData= response.as(HashMap.class);

        System.out.println("actualData = " + actualData);

        assertEquals(zippopotamPojos.getPostCode(), actualData.get("post code"));
        assertEquals(zippopotamPojos.getCountry(), actualData.get("country"));
        assertEquals(zippopotamPojos.getCountryAbbreviation(), actualData.get("country abbreviation"));
        assertEquals(zippopotamPojos.getZippopotamPlacePojo().getPlaceName(), (((Map)((List)actualData.get("places")).get(0)).get("place name")));
        assertEquals(zippopotamPojos.getZippopotamPlacePojo().getLongitude(), (((Map)((List)actualData.get("places")).get(0)).get("longitude")));
        assertEquals(zippopotamPojos.getZippopotamPlacePojo().getState(), (((Map)((List)actualData.get("places")).get(0)).get("state")));
        assertEquals(zippopotamPojos.getZippopotamPlacePojo().getStateAbbreviation(), (((Map)((List)actualData.get("places")).get(0)).get("state abbreviation")));
        assertEquals(zippopotamPojos.getZippopotamPlacePojo().getLatitude(), (((Map)((List)actualData.get("places")).get(0)).get("latitude")));


    }




}
