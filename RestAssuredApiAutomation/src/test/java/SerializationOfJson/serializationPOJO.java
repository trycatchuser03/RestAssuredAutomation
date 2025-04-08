package SerializationOfJson;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serializationPOJO {
	
	 String email;
	 String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Test
	public void execution() throws JsonProcessingException {
		serializationPOJO serial  = new serializationPOJO();
		serial.setEmail("comeagainagain@gain.com");
		serial.setPassword("word1234$$");
		
		System.out.println(serial.getEmail());
		System.out.println(serial.getPassword());
		
		
		ObjectMapper map =  new ObjectMapper();
		String bodyJson = map.writerWithDefaultPrettyPrinter().writeValueAsString(serial);
		System.out.println(bodyJson);
	}

}
