package HomeWork;

import baseURL.Homework_01;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task01 extends Homework_01 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

 */
@Test
    public void test(){

    specification.pathParams("pathBooking", "booking");

   Response response = given().spec(specification).when().get("/{pathBooking}");
    response.prettyPrint();

    response.then().assertThat()
            .statusCode(200)
            .body(containsString("bookingid"));
            //.body("firstname", hasItems("Sarah"));


}

/*
-> assertTrue(response.body().asString().contains("bookingid"));
->String responseBodyStr= response.asString();
        assertTrue(responseBodyStr.contains("bookingid"));

 */
}
