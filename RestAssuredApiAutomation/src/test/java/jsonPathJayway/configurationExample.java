package jsonPathJayway;

import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class configurationExample {
	String loc = "{\r\n"
			+ "    \"store\": {\r\n"
			+ "        \"book\": [\r\n"
			+ "            {\r\n"
			+ "                \"category\": \"reference\",\r\n"
			+ "                \"author\": \"Nigel Rees\",\r\n"
			+ "                \"title\": \"Sayings of the Century\",\r\n"
			+ "                \"price\": 8.95\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"category\": \"fiction\",\r\n"
			+ "                \"author\": \"Evelyn Waugh\",\r\n"
			+ "                \"title\": \"Sword of Honour\",\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    }\r\n"
			+ "}";
	
//	File loc = new File("src/test/resources/ForJsonPath.json");
	
	public void returnsNullinPath () throws IOException {
		
//		
		Configuration configuration = Configuration.defaultConfiguration();
		configuration = configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);//returns null if the json path is invalid and continues the execution.
		
//		another way of declaring the above implementation 
//		Configuration configuration = Configuration.builder().options(Option.DEFAULT_PATH_LEAF_TO_NULL).build();
		
		String results = JsonPath.using(configuration).parse(loc).read("$.sll,mkmknitleh");
		System.out.println(results);
//		for(Object result : results ) {
//			System.out.println(result);
//		}
	}
	
	public void method2() {
		Configuration configuration = Configuration.builder().options(Option.ALWAYS_RETURN_LIST).build(); // always returns the result as List.whether it is definite or indefinite path.
//		Configuration configuration = Configuration.defaultConfiguration();
		List<Object> result = JsonPath.using(configuration).parse(loc).read("$.store.book[0].author");
		System.out.println(result);
		
	}
	
	public static void main(String[] args) throws IOException {
		configurationExample config = new configurationExample();
		config.method2();
		
	}

	
}
