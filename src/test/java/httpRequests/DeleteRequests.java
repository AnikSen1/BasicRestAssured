package httpRequests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteRequests {
	
	@Test
    public void firstDelete() {
    	baseURI="http://localhost:3000";
    	
    	given()
    		.header("Content-Type","application/json")
    		.header("Cache-Control","no-cache")
    	
    	.when()
    		.delete("/users/4")
    	.then()
	    	.statusCode(200)
	    	.statusLine("HTTP/1.1 200 OK")
	    	.log().all();	
    }
	
	
}
