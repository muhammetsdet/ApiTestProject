public class ApiTrick {
/*
Expected Result
 ---->>> Kendi hazırlamış olduğum dokumanlardan, test caselerden alıyourum.
Actual Result
 -------->> WebPage (Selenium)     Response (API)
 Expected Resultları yani Dataları depolamak için farklı yöntemler kullanbilirim.
  --> DB
  --> Cucumber da feature filedan alıyoruz.
  --> Excel den apachi POI
  --> POJO claslardan depolayabilirsiniz.
  --> ObjectMapper vasıtasıyla istediğiniz class a convert edebilirsiniz.
  -->Expected Resultaları depolayabilmek için Java nınnbizlere sağlamış olduğu çeşitli Collection
  yapılarını kullanarak (List, Map ) expected datalarımızı depoyabildik.
  Actual Resultları yani DAtaları depolamak için bizler REPSONSE u kaullnıyourz.
         Amaç: Response objesi üzerinde manipulation işlemleri yapabilmek yani RESPONSE a ulaşabilmek.
    1) response.then(). asserthat().body(..................)   -----> Body nin içerisine girebilmek
    2) JsonPath  clasını kullanbiliriz. -----> response.jsonPath()  --->
    REsponse u jsonPath atamak ve JsonPath in bir takım özel metotları vasıtasıyla
    response obj. navigate edebilmek.
    3) GSON  --> Json objelerini Java obj. lerine çevirmeye yaran bir yöntemdir. Bizler bu yönteme De-ser. deriz.
    Bu yöntemi kullanbilmek için pom.xml e bir tane dependcy eklememiz gerekir.
    Benim response body im MAP formatında gibi ise response objesi ile map e çevirebilriz.
    response.as(HashMap.class)
    4) Object Mapper --> Json objelerini Java obj. lerine çevirmeye yaran bir yöntemdir. Bizler bu yönteme De-ser. deriz.
    Bu yöntemi kullanbilmek için pom.xml e bir tane dependcy eklememiz gerekir.
    utilities pack. altında oluşturğdumuz bir tane class ın içinde bulunan metot vasıtasıyla Json obj. lerimiz Java obj. çevirebilriz.
    response
    Hangi Classs ise = convertJsonToJavaObject(response.asString(), Class<T> cls)
    5) POJO class yöntemi ile bizler response objemiz üzerinde manipulation yapabiliriz.
    *** NOTE: Eğer sen response unu POJO da tutacak isen response ile POJO aynı formatta olmalıdır.
    Eğer değilse @JsonIgnoreProperties(ignoreUnknown = true) annotaion ı kullanmayalım. Fakat her ne kadar bunun ile aynı omayan key leri ignore ediyor olsamda
    bazen tam olarak çevirmyebilr. Bu noktada çeşitli yöntemler ile doğru dataı set lemeni gerekmektedir.
    Ex: <<PojoClasName>> = response.as(<<PojoClasName>>.class)
    -->//JsonPath response içerisinde gezinmemizi sağlar.
    -->Javada class'lar küçük harfle olmaz
    -->Decoder sitesi şifre çözücü olarak kullanılabilri.
    -->
    -->
    -->
    -->
    -->


 */
}
