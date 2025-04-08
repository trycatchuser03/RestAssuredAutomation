package DesrializationOfJson;

import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import SerializationOfJson.serializationPOJO;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class Deserialization {

	String body = "{\r\n"
			+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
			+ "    \"password\": \"pistol\"\r\n"
			+ "}";
	@Test(enabled = false)
	public void DeserializationJson() throws JsonMappingException, JsonProcessingException {

		ObjectMapper map = new ObjectMapper();

		serializationPOJO readValue = map.readValue(body, serializationPOJO.class);

		System.out.println(readValue.getEmail());
		System.out.println(readValue.getPassword());
	}
	
	@Test(enabled = false)
	public void usingJaywayJsonPath() {
		
		JacksonMappingProvider mapping = new JacksonMappingProvider();
		
		Configuration config = Configuration.builder().mappingProvider(mapping).build();
		
		serializationPOJO read = JsonPath.using(config).parse(body).read("$",serializationPOJO.class);
		
		System.out.println(read.getEmail());
		System.out.println(read.getPassword());
		
	}
	
	@Test(enabled = false)
	public void usingRaJsonPath() {
		
		io.restassured.path.json.JsonPath jsonPath = io.restassured.path.json.JsonPath.from(body);
		serializationPOJO object = jsonPath.getObject("", serializationPOJO.class);
		System.out.println(object.getEmail());
		System.out.println(object.getPassword());
		
	}
	
	@Test
	public void Asfunction() {
		Map<String, Object> response = RestAssured
		.given()
		.baseUri("https://reqres.in/")
		.when()
		.get("api/users?page=2")
		.then()
		.extract()
		.as(new TypeRef <Map<String,Object>>() {
		});
		System.out.println(response);
		System.out.println(response.get("page"));
		System.out.println(response.get("per_page"));
		System.out.println(response.get("total"));
		System.out.println(response.get("total_pages"));
		System.out.println(response.get("data"));
	}

}
