package authenticationAndAuthorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;



public class OAuth2 {

	
//	//@Test
//	public void test1() {
//	baseURI="http://coop.apps.symfonycasts.com/api";
//	
//		given()
//			.auth()
//			.oauth2("8b3f99fe15e0f1300a679025aff0f6268faf660d")
//		.when()	
//			.post("/2992/chickens-feed")
//		.then()
//			.statusCode(200)
//			.log().all();
//	}
	
	@Test
	public void accessValidAPI() {
	
	Response response=
		
		given()
			.formParam("client_id", "MukeshAutomation")
			.formParam("client_secret", "7ea2f3e2757a289086727cde94a5c35f")
			.formParam("grant_type", "client_credentials")
			.post("http://coop.apps.symfonycasts.com/token");
	
	//System.out.println(response.jsonPath().prettify());
	    String token=response.jsonPath().get("access_token");
	    System.out.println(token);
	   
	    
	    baseURI="http://coop.apps.symfonycasts.com/api";
	  

	given()
		.auth()
		.oauth2(token)
	.when()	
		.post("/2992/chickens-feed")
	.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	@Test
	public void accessInvalidAPI() {
	
	Response response=
		
		given()
			.formParam("client_id", "MukeshAutomation")
			.formParam("client_secret", "7ea2f3e2757a289086727cde94a5c35f")
			.formParam("grant_type", "client_credentials")
			.post("http://coop.apps.symfonycasts.com/token");
	
	//System.out.println(response.jsonPath().prettify());
	    String token=response.jsonPath().get("access_token");
	    System.out.println(token);
	   
	    
	    baseURI="http://coop.apps.symfonycasts.com/api";
	  
	  
	given()
		.auth()
		.oauth2(token)
	.when()	
		.post("/2992/eggs-count")
	.then()
		.statusCode(401)
		.log().all();
		
	}
}
