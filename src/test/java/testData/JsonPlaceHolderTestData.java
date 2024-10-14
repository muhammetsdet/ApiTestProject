package testData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {

 /*
            Assert that Status Code is "200"
            Assert that the Server is cloudflare in the Header

          {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
          }
 */
public static HashMap<String, Object> expectedDataMap= new HashMap<>();

public HashMap setUpDataTodos(){

expectedDataMap = new HashMap<>();
expectedDataMap.put("Statuscode",200);
expectedDataMap.put("Server","cloudflare");
expectedDataMap.put("userId",1);
expectedDataMap.put("id",2);
expectedDataMap.put("title","quis ut nam facilis et officia qui");
expectedDataMap.put("completed",false);

return expectedDataMap;
}

}
