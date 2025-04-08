package BDDApproach;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class APIMethods {

	@Test(enabled = false)

	public void getMethod(){
		given().baseUri("https://reqres.in/")
		.when().get("api/users/3")
		.prettyPrint();

	}

	@Test(enabled=true)
	public void postMethod() {
		String a = given().baseUri("https://login.microsoftonline.com/")
		.contentType(ContentType.URLENC)
		.cookie("fpc=AiBvoLgvEOpOkp5pDHk7RuUmlrRDAQAAAG2NQdwOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
		//body for form url
		.formParam("client_id", "6ce951b6-4b94-4bb2-bdeb-096e8063fa7f")
		.formParam("client_secret", "nUO8Q~elq4qaqVgig4~AuLsg4_AWiBb5QvJ26bTe")
		.formParam("grant_type", "Client_Credentials")
		.formParam("Resource", "6ce951b6-4b94-4bb2-bdeb-096e8063fa7f")
		//		.header("Content-Type","application/x-www-form-urlencoded")
		//		.header("Cookie","fpc=AiBvoLgvEOpOkp5pDHk7RuUmlrRDAQAAAG2NQdwOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
		//		.body("{\r\n"
		//				+ "    \"name\": \"hendrickk\",\r\n"
		//				+ "    \"job\": \"chief person\"\r\n"
		//				+ "}")
		.when().post("f3211d0e-125b-42c3-86db-322b19a65a22/oauth2/token")
		.then()
		.extract()
		.response()
		.asPrettyString();
		System.out.println(a);
		
//		1. RestAssured's way to fetch access_token 
//		JsonPath j1 = JsonPath.from(a);
//		System.out.println(j1.getString("access_token"));

//		2. RestAssured's way to fetch access_token
//		JsonPath j2 = new JsonPath(a);
//		System.out.println(j1.getString("access_token"));
		
//		Jayway json path to fecth access token 
		List <Object> tokens = com.jayway.jsonpath.JsonPath.read(a,"$..access_token");
		for(Object token : tokens)
		System.out.println(token);
		
	}


	@Test(enabled=false)
	public void patchMethod() {
		given().baseUri("https://reqres.in").header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"hero stalin\",\r\n"
				+ "    \"job\": \"zathlete\"\r\n"
				+ "}")
		.when().patch("/api/users/111")
		.prettyPrint();
	}

	@Test(enabled=false)
	public void deleteMethod() {
		given().baseUri("https://reqres.in")
		.when().delete("/api/users/111")
		.prettyPrint();
	}

}
