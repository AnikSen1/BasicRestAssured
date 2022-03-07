package httpRequests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequests {
	
	@Test
    public void firstPut() {
    	baseURI="http://localhost:3000";
    	JSONObject httpReq=new JSONObject();
    	
    	
    	httpReq.put("lastName", "Shawon");
    
    	
    	given()
    		.contentType(ContentType.JSON)
    		.accept(ContentType.JSON)
    		.header("Cache-Control","no-cache")
    		.body(httpReq.toJSONString())
    	
    	.when()
    		.patch("/users/5")
    	.then()
	    	.statusCode(200)
	    	.statusLine("HTTP/1.1 200 OK")
	    	.log().all();	
    }
	
	
}
