package rest.clients;
import static com.pids.utils.PidsCommonConstants.BODY;
import static com.pids.utils.PidsCommonConstants.HEADER;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pids.controllers.UserLoginController;
import com.pids.core.MessageHeader;
import com.pids.entity.User;


public class MainClientTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//testCreate(); 
		testCreateWithMultiple();

	}

	private static void testCreate() throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		MessageHeader header=new MessageHeader();
		header.setStatus("success");
		RestTemplate template=new RestTemplate();
		User user=new User();
		user.setDeviceId("123456");
		user.setEmailId("kkt");
		user.setMobile("7411415955");
		user.setPassword("password");
		map.put(HEADER, header);
		map.put(BODY, user);
		Map<String,Object> hashmap=template.postForObject("http://localhost:8086/pids-poc"+UserLoginController.USER_CREATE, map, Map.class);
		System.out.println("Header is:"+hashmap.get(HEADER));
		System.out.println("Body is:"+hashmap.get(BODY));
		
	}

	private static void testCreateWithMultiple() throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		MessageHeader header=new MessageHeader();
		header.setStatus("success");
		RestTemplate template=new RestTemplate();
		User user=new User();
		user.setDeviceId(generateUniqueString());
		map.put(HEADER, header);
		map.put(BODY, user);
		Map<String,Object> hashmap=template.postForObject("http://localhost:8086/pids-poc"+UserLoginController.USER_CREATE, map, Map.class);
		System.out.println("Header is:"+hashmap.get(HEADER));
		System.out.println("Body is:"+hashmap.get(BODY));
		
	}
	
	public static String generateUniqueString() {
		System.out.println("hi");
		try{
		Date date=Calendar.getInstance().getTime();  
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddSSss");
		String uniqueString=df.format(date);
		return uniqueString;
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return null;
	}

}
