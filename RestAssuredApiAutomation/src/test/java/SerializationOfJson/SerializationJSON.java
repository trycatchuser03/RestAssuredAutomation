package SerializationOfJson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class SerializationJSON {
	

	
	@Test
	public void serialization() {
		
		Map<String, Object> jsonObj = new LinkedHashMap<String, Object>();
		
		jsonObj.put("name", "jifer");
		jsonObj.put("job", "Tester");
//		jsonObj.put("id", "3");
		
		Set <String> skills = new HashSet <String>();
		skills.add("Java");
		skills.add("Selenium");
		skills.add("Jmeter");
		
		jsonObj.put("skills", skills);
		
		System.out.println(jsonObj);
		
		
//		given().baseUri("https://reqres.in/").header("Content-Type","application/json")
//		.body(jsonObj)
//		.when().post("api/users")
//		.prettyPrint();
		
	}

}
