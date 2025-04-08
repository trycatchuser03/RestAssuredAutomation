package JsonSchemaValidations;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class jsonSchemaNetworkNT {

	@Test
	public void schemaValidationNetworkNT() throws IOException {
		//getting the schema for input request from file
		FileInputStream fis = new FileInputStream("src/test/resources/schema.json");

		//getting input request from file 
		Reader readFile = new FileReader("Body.json");

		ObjectMapper map = new ObjectMapper();
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);

		//getting input request
		JsonNode bodyInput = map.readTree(readFile);

		//getting the schema for input request
		JsonSchema jsonSchema = factory.getSchema(fis);

		//For validating request against the schema
		Set<ValidationMessage> validate = jsonSchema.validate(bodyInput);

		if(validate.isEmpty()) {
			System.out.println("No error validation is found");
		}
		else {
			for(ValidationMessage msg : validate) {
				System.out.println(msg);
			}
			Assert.assertTrue(false);
		}

	}

}
