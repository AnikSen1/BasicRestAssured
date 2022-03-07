package httpRequests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;


public class JSONSchemaValidator {
	
	
		@Test
		public void getJSONSchemaValidation() {
			
			baseURI = "https://reqres.in/api";
			
			given()
			.header("Content-Type","application/json")
    		.when()
				.get("/users?page=2")
			.then()
				.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
		    	.log().all();	
			
		}
}