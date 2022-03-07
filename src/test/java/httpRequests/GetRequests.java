package httpRequests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetRequests {
	
	@Test
    public void firstGet() {
    	baseURI="http://localhost:3000";
    	
    	given()
    		.header("Content-Type","application/json")
    		.header("Cache-Control","no-cache")
    	
    	.when()
    		.get("/users?id=5")
    	.then()
	    	.statusCode(200)
	    	.statusLine("HTTP/1.1 200 OK")
	    	.log().all();	
    }
	
	
}
