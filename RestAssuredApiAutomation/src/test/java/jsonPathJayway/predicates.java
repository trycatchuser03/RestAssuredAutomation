package jsonPathJayway;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class predicates {
	File loc = new File("src/test/resources/ForJsonPath.json");
	
	public void predicateInline() throws IOException {
	List <Map<String,Object>> results = JsonPath.parse(loc).read("$.store.book.[?(!(@.price<10 && @.category == 'reference'))]");
//	List <Object> results = JsonPath.parse(loc).read("$.store.book.[?(@.price>10)]");
	//use of map over only object 	
	System.out.println(results);
	System.out.println(results.get(0).containsValue("Nigel Rees"));
	
		for(Object result : results ) {
			System.out.println(result);
		}
	}
	
	
	public void filterApiPredicate() throws IOException {
		Filter filter = Filter.filter(
				Criteria
				.where("price")
				.gt(20)
				.and("category")
				.is("reference")
				);
		Object read = JsonPath.parse(loc).read("$.store.book[?]",filter);
		System.out.println(read);
		
	}
	
	public void ownPredicate() throws IOException {
//		Predicate isbnBook = new Predicate() {
//			
//			@Override
//			public boolean apply(PredicateContext ctx) {
//				// TODO Auto-generated method stub
//				boolean predicate = ctx.item(Map.class).containsKey("isbn");
//				return predicate;
//			}
//		};
		
		//using lambda expression (java 8 concept)
		Predicate isbnBook = ctx -> ctx.item(Map.class).containsKey("isbn");
		
		
		List <Map<String,Object>> result = JsonPath.parse(loc).read("$.store.book[?]",isbnBook);
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException {
		predicates pred = new predicates();
//		pred.predicateInline();
//		pred.filterApiPredicate();
		pred.ownPredicate();
	}


}
