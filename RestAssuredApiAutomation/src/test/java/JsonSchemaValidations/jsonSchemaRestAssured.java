package JsonSchemaValidations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class jsonSchemaRestAssured {
	//RestAssured  json schema validator is used 
	//only able to compare and validate the response  body 
	
@Test(enabled = true)	
	public void schemaValidatorWithInClassPath() {
		
		File f = new File("./Body.json");
		RestAssured
		.given().baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(f)
		.when()
		.post("api/users")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}


@Test(enabled = true)
 public void schemaValidator() throws FileNotFoundException {

		File f = new File("Body.json");
		FileInputStream o = new FileInputStream("src/test/resources/schema.json");
		RestAssured
		.given().baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(f)
		.when()
		.post("api/users")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchema(o));
		
		
	 
 }
}
