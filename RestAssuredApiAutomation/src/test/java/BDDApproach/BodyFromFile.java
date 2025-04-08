package BDDApproach;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class BodyFromFile {
	
	@Test
	public void bodyFromFile() throws FileNotFoundException {
		File f = new File("./Body.json");
		FileInputStream fis = new FileInputStream(f);
		given().baseUri("https://reqres.in/")
		.header("Content-Type","application/json")
		.body(fis)
		.when().post("api/register")
		.prettyPrint()
;		
	}

}
