package httpRequests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequests {
	
	@Test
    public void firstPost() {
    	baseURI="http://localhost:3000";
    	JSONObject httpReq=new JSONObject();
    	
    	httpReq.put("firstName", "Shirin");
    	httpReq.put("lastName", "Begum");
    	httpReq.put("subjectId", 1);
    	
    	given()
    		.contentType(ContentType.JSON)
    		.accept(ContentType.JSON)
    		.header("Cache-Control","no-cache")
    		.body(httpReq.toJSONString())
    	
    	.when()
    		.post("/users")
    	.then()
	    	.statusCode(201)
	    	.statusLine("HTTP/1.1 201 Created")
	    	.log().all();	
    }
	
	
}
