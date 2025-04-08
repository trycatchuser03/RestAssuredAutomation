package JsonSchemaValidations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class jsonSchemaHamcrestMatcher {
	@Test

	public void  hamcrestMatch() throws IOException {
		//getting the schema for input request from file
		File schemaJson = new File("src/test/resources/schema.json");

		//getting input request from file 
		File inputJson = new File("Body.json");
		//Converting File to String 
		String StringFile = FileUtils.readFileToString(inputJson,"UTF-8");

		//Asserting input request with Schema
		MatcherAssert.assertThat(StringFile, JsonSchemaValidator.matchesJsonSchema(schemaJson));
	}
}
