package httpRequests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequests {
	
	@Test
    public void firstPut() {
    	baseURI="http://localhost:3000";
    	JSONObject httpReq=new JSONObject();
    	
    	httpReq.put("firstName", "MD");
    	httpReq.put("lastName", "Salam");
    	httpReq.put("subjectId", 1);
    	
    	given()
    		.contentType(ContentType.JSON)
    		.accept(ContentType.JSON)
    		.header("Cache-Control","no-cache")
    		.body(httpReq.toJSONString())
    	
    	.when()
    		.put("/users/5")
    	.then()
	    	.statusCode(200)
	    	.statusLine("HTTP/1.1 200 OK")
	    	.log().all();	
    }
	
	
}
