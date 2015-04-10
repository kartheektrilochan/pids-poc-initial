import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pids.controllers.UserLoginController;
import com.pids.entity.User;


public class MainClienTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		testCreate(); 

	}

	private static void testCreate() throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		RestTemplate template=new RestTemplate();
		User user=new User();
		user.setId("123");
		user.setUsername("kkt");
		User responseUser=template.postForObject("http://localhost:8086/pids-poc"+UserLoginController.USER_CREATE, user, User.class);
		ObjectMapper mapper=new ObjectMapper();
		mapper.writer().writeValue(System.out, responseUser);
	}

}
