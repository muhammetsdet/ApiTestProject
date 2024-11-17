package postRequest;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends GoRestApiBaseURL {

/*
        Given
            https://gorest.co.in/public/v2/users
        When
            Kullanıcı Post Methodu ile Request Gönderir
        Then
            Status Code'un "422" olduğunu Assert et


 */

    @Test
    public void post02() {
        //Set the URL
        specification.pathParams("usersPath", "users");

        //Set the expected data
        GoRestApiTestData GoRestApiTestData = new GoRestApiTestData();
        System.out.println("GoRestApiTestData.statusCodeForInvalidPost() = " + GoRestApiTestData.statusCodeForInvalidPost());

        //Send the request
        Response response = given().spec(specification).when()
                .header("Authorization", "Bearer 782b75699939a85ec01b26b0a015d718e7f1127a6856bf0ff3a8731f99fbc65a")
                .post("/{usersPath}/{idPath");
        response.prettyPrint();

        //Assertion
        assertEquals(GoRestApiTestData.statusCodeForInvalidPost(),response.statusCode());
        response.then().assertThat().statusCode(GoRestApiTestData.statusCodeForInvalidPost());
        response.then().assertThat().statusCode(422);
        //-> 3 Farklı assert denenebilir

        

    }

}
