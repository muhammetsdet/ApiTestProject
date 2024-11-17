package postRequest;

import baseURL.GoRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Post01Possitive extends GoRestApiBaseURL {

//Bearer 782b75699939a85ec01b26b0a015d718e7f1127a6856bf0ff3a8731f99fbc65a
    /*
    Given
            https://gorest.co.in/public/v2/users
        When
            Kullanıcı Post Methodu ile Request Gönderir
         And
            Kullanıcı Request Body'i gönderir
             {
        "id": 7529231,
        "name": "Muhammet Deneme",
        "email": "atas_12@hotmail.com",
        "gender": "male",
        "status": "inactive"
    } --> Request Body/Expected Data her ikisini de içeriyor. Hem gönderiyoruz hem cevap olarak alıyoruz.
        Then
            Status Code'un "201" olduğunu Assert et
         Then
            Response'un gönderilen data formatıyla aynı olduğunu assert ediniz
     */

    @Test
    public void post01Possitive() {
        //Set the URL
        specification.pathParams("usersPath", "users");

        //Set the expected data

        GoRestApiPojo goRestApiPojo = new GoRestApiPojo("1", "Muhammet Deneme", "atas9_@hotmail.com", "male", "inactive");

//        HashMap<String, String> requestBodyAndExpectedData = new HashMap<>();
//        requestBodyAndExpectedData.put("name", "Muhammet Deneme");
//        requestBodyAndExpectedData.put("email", "atas3_@hotmail.com");
//        requestBodyAndExpectedData.put("gender", "male");
//        requestBodyAndExpectedData.put("status", "inactive");

        //Send the request

        Response response = given().spec(specification).body(goRestApiPojo)
                .contentType(ContentType.JSON) /*.contentType("application/json") ->Her ikiside doğru sonucu verir.*/
                .when()
                .header("Authorization", "Bearer 782b75699939a85ec01b26b0a015d718e7f1127a6856bf0ff3a8731f99fbc65a")
                .post("/{usersPath}");

        response.prettyPrint();
        response.then().statusCode(201);

        //Do the assertion
        //HashMap<String, Object> actualData= JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        HashMap<String, String> actualDataMap = response.as(HashMap.class);

        assertEquals(goRestApiPojo.getName(), actualDataMap.get("name"));
        assertEquals(goRestApiPojo.getGender(), actualDataMap.get("gender"));
        assertEquals(goRestApiPojo.getEmail(), actualDataMap.get("email"));
        assertEquals(goRestApiPojo.getStatus(), actualDataMap.get("status"));
        //assertEquals(goRestApiPojo.getId(),actualDataMap.get("id"));


    }


}
