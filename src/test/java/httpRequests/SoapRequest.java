package httpRequests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapRequest {
	@Test
	public void soapGet() throws IOException {
		
		File file=new File("./xmlRequests/Add.xml");
		FileInputStream input=new FileInputStream(file);
		String requestBody=IOUtils.toString(input, "UTF-8");
		
		baseURI="https://ecs.syr.edu/faculty/fawcett/handouts/cse686/code/calcWebService";
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/Calc.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:AddResult.text()", equalTo("10"));
	}

}
