package jsonPathJayway;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class jsonPathFetch {

	public static void parsingEveryTime() throws IOException {
		File loc = new File("src/test/resources/ForJsonPath.json");
		List <Object> authors = JsonPath.read(loc, "$..author");

		for(Object author:authors ) {
			System.out.println(author);
		}

	}
	
	public static void parsingOneTime() throws IOException {
		//passing file input stream and converting to byte data type
		FileInputStream loc = new FileInputStream("src/test/resources/ForJsonPath.json");
		Object parse = Configuration.defaultConfiguration().jsonProvider().parse(loc.readAllBytes());
		
		// passing file and converting to string  data tybe
//		File loc = new File("src/test/resources/ForJsonPath.json");
//		String json = FileUtils.readFileToString(loc,"UFT-8");
//		Configuration.defaultConfiguration().jsonProvider().parse(json);
		
		List<Object> titles = JsonPath.read(parse, "$['store']['book'][0:3]['title']"); //definite json path
		
		for(Object title:titles ) {
			System.out.println(title);
		}
	}
	
	public static void fluentParse() throws IOException {
		//Method 1
		File loc = new File("src/test/resources/ForJsonPath.json");
//		Object exp  = JsonPath.parse(loc).read("$..expensive");
//		System.out.println(exp);
		
		//Method 2 
		Configuration defaultConfiguration = Configuration.defaultConfiguration();
		List<Object> reads = JsonPath.using(defaultConfiguration).parse(loc).read("$..expensive"); //indefinite json path 
		for(Object read: reads) {
		System.out.println(read);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		fluentParse();
	}

}
