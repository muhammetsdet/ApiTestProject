package getRequests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
     /*
        Till now, we have sent different http requests Postman for API testing having different documents.

        In the market, we generally use POSTMAN as a manual API test tool not for the automation.
        But as we have learned previously in our sessions, POSTMAN also can be used for API test automation.

        From now on, we will use RestAssured Library for API test automation process.

        To be able to do test, you need a document.
        We, as Test Engineers, can apply how to use http reqs and how to to do our tests APIs.
        Besides, we can create test cases and scenarios by following documents. Just like we follow UI and create test cases
        and run those test cases in Selenium Web UI.

        Test Case:

         --> Expected Result  // TEST CASE


         ---> Actual Result      ====>>>>> I will get from response from API

        Gherkin Lang.

            Given ---> Pre-requisite of test
            When ---> Action
            Then ---> Assertion
            And  ---> shows that the effect of the previous action continues

     */

    /*
We have 4 steps in API testing in general.

1)We should identify/set the URL

2)We should set the expected data. Expected data is provided by using documents for Test Cases.
For now, we will ignore this step.


3)Send Request --> SEND button in Postman

4)Do Assertion
 */

/*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        User sends GET Request
    Then
        Assert that Status Code is "200"
    And
        Assert that Content Type is in "application/json"
    And
        Assert that Status Line is "HTTP/1.1 200 OK"

        Şimdiye kadar API testi için Postman'e farklı dokümanlara sahip farklı http istekleri gönderdik.
        Piyasada POSTMAN'ı genellikle otomasyon için değil, manuel bir API test aracı olarak kullanıyoruz.
        Ancak daha önce oturumlarımızda öğrendiğimiz gibi, POSTMAN API test otomasyonu için de kullanılabilir.
        Bundan sonra API test otomasyonu için RestAssured Kütüphanesini kullanacağız.
        Test yapabilmek için bir dokümana ihtiyacınız var.
        Biz Test Mühendisleri olarak http req'lerini nasıl kullanacağımızı ve API testlerimizi nasıl yapacağımızı uygulayabiliriz.
        Bunun yanında dokümanları takip ederek test case ve senaryoları oluşturabiliriz. Tıpkı UI'yi takip edip test senaryoları oluşturduğumuz gibi
        ve bu test senaryolarını Selenium Web UI'da çalıştırın.
        Test Vakası:
         --> Beklenen Sonuç // TEST DURUMU
         ---> Gerçek Sonuç ====>>>>> API'den gelen yanıttan alacağım
        Gherkin Lang.
            Verilen ---> Testin ön koşulu
            Ne zaman ---> Eylem
            O zaman ---> İddia
            Ve ---> bir önceki eylemin etkisinin devam ettiğini gösterir
    Verilen
        https://restful-booker.herokuapp.com/booking/7
    Ne zaman
        Kullanıcı GET İsteği gönderir
    O zaman
        Durum Kodunun "200" olduğunu doğrulayın
    Ve
        İçerik Türünün "application/json" içinde olduğunu doğrulayın
    Ve
        Durum Satırının "HTTP/1.1 200 OK" olduğunu doğrulayın

     */
@Test
    public void userDataCheck(){
    // 1)We should identify/set the URL
String URL= "https://restful-booker.herokuapp.com/booking/7";

// 2)We should set the expected data. Expected data is provided by using documents for Test Cases.
// For now, we will ignore this step.

// 3)Send Request --> SEND button in Postman
// Given
//        https://restful-booker.herokuapp.com/booking/7
//    When
//        User sends GET Request
  Response response=  given().when()/*->action*/.get(URL);

//Assert that Status Code is "200"
    response.then().assertThat().statusCode(200);

    // Assert that Content Type is in "application/json"
    response.then().assertThat().contentType("application/json");

    //Assert that Status Line is "HTTP/1.1 200 OK"
    response.then().assertThat().statusLine("HTTP/1.1 200 OK");

    response.prettyPrint(); //sout gibi bütün datayı gösterir

    //sadece status code veya content type yazdırmak için
    System.out.println("Response= "+response.getStatusCode()); //datayı parça parça almak için
    System.out.println("Content type= "+response.getContentType());

    //response time yazdırmak için
    System.out.println("Time= " + response.getTime());

    //headers yazdırmak için
    System.out.println("Headers= " + response.getHeaders());
}


}
