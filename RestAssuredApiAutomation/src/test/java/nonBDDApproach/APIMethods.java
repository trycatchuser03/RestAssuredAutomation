package nonBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIMethods {

	@Test(enabled=false)
	public void getMethod() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification requestSpecification = RestAssured.given();

		//For single user
//		Response response = requestSpecification.request(Method.GET,"api/users/3");
		
		//For multiple users
		Response response = requestSpecification.request(Method.GET,"api/users?page=2");

		response.prettyPrint();
		System.out.println(response.getStatusCode());

	}

	@Test(enabled = false)
	public void postMethod() {
		RestAssured.baseURI="https://reqres.in/";

		RequestSpecification requestSpecification = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"name\": \"zaasuressh\",\r\n"
						+ "    \"job\": \"aaraina\"\r\n"
						+ "}");

		Response response = requestSpecification.request(Method.POST,"api/users");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());


	}

	@Test(enabled = true)
	public void putMethod() {
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification requestSpecification = RestAssured.given()
				.header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"house keeping\"\r\n"
						+ "}");
		
		Response response = requestSpecification.request(Method.PUT, "/api/users/7");
		
		System.out.println(response.asPrettyString());
			
	}
	
	@Test(enabled = false)
	public void deleteMethod() {
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		Response response = requestSpecification.request(Method.DELETE, "/api/users/7");
		
		System.out.println(response.asPrettyString());
		
		
	}
}
