package com.pids.controllers;

import static com.pids.utils.PidsCommonConstants.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pids.core.MessageHeader;
import com.pids.entity.AddressDetail;
import com.pids.entity.User;
import com.pids.exceptions.PidsException;
import com.pids.service.IUserLoginService;

@Controller
public class UserLoginController {

	public static final String TEST_UR_REST = "/pids/rest/test";
	private final static Logger LOGGER = Logger.getLogger(UserLoginController.class);

	@Autowired
	private IUserLoginService userService;

	private User userEntity;
	/*
	 * @RequestMapping(value=LOGINSERVIE_URLPATH, method = RequestMethod.GET)
	 * public ModelAndView getDetails(@ModelAttribute("command") User user) {
	 * System.out.println("Calling service controller"); Map<String, Object>
	 * model = new HashMap<String, Object>(); model.put("employees",
	 * userService.getUserDetails(user)); return new
	 * ModelAndView("employeesList", model); }
	 */

	/*@RequestMapping(value = LOGINSERVIE_URLPATH + "/{" + PV_USERNAME + "}", method = RequestMethod.GET)
	public @ResponseBody String checkLoginDetails(
			@PathVariable(PV_USERNAME) String userName) {
		System.out.println("calling checklogindetails method");
		LOGGER.info("User login requested:" + userName);
		User user = new User();
		// user.setUsername(userName);
		userService.getUserDetails(user);
		return "hi";
	}*/

	/*@RequestMapping(value = TEST_UR_REST, method = RequestMethod.GET)
	public @ResponseBody String testRest(
			@PathVariable(PV_USERNAME) String userName) {
		LOGGER.info("User login requested:" + userName);
		return "hi rest is working";
	}
*/
	/*Create User-RestFul Service*/
	/*Before creating the user check for the device id is already registered in database or not
	 * 
	 * */
	
	@RequestMapping(value = USER_REGISTRATION, method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody Map<String,Object> createUser(@RequestBody Map<String,User> requestMap) {
		Map<String,Object> responseMap=new HashMap<String, Object>();
		User user=(User) requestMap.get(BODY);
		System.out.println("Rest-service called:" + USER_REGISTRATION);
		String device_id = user.getDeviceId();
		try {
			if (device_id != null) {
				/* check for existing device id */
				List<User> existingUsers = userService.findByDeviceId(device_id);
				if (existingUsers.size() != 0) {
					System.out.println("****Creation Failed::" + device_id+ " already exists");
					throw new PidsException(PidsException.INVALID_DATA_EXCEPTION+"::Device Id already exists");
				} else {
					/*createObjectWithData(user);*/
					User newUserObject = createObjectWithData(user);
					userService.save(newUserObject);
					responseMap.put(BODY, newUserObject);
					responseMap.put(HEADER,new MessageHeader("SUCCESS", "S01", "User Created"));
					return responseMap;
				}
			}
			else{
				throw new PidsException(PidsException.INVALID_DATA_EXCEPTION+"::Device Id is blank");
			}
		} catch (PidsException pidsexception) {
			responseMap.put(BODY, user);
			responseMap.put(HEADER,new MessageHeader("FAILURE", "F01", "Service:"+USER_REGISTRATION+" and exception is:"+pidsexception));
			return responseMap;
		}
	}
	
	@RequestMapping(value = USER_LOGIN, method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody Map<String,Object> checkLogin(@RequestBody Map<String,User> requestMap) {
		Map<String,Object> responseMap=new HashMap<String, Object>();
		User user=(User) requestMap.get(BODY);
		boolean validDetails=validateRequestDetails(user);
		try{
			if(validDetails){
				if(authenticateUser(user))
				{
					responseMap.put(BODY, user);
					responseMap.put(HEADER, new MessageHeader("SUCCESS","S02","Login Successful"));
					return responseMap;
				}else{
					throw new PidsException(PidsException.INVALID_DATA_EXCEPTION+"::Login Unsuccessful");
				}
			}
			else{
				throw new PidsException(PidsException.INVALID_DATA_EXCEPTION+"::Device Id is blank");
			}
		}catch(PidsException pidsException){
		responseMap.put(BODY, user);
		responseMap.put(HEADER,new MessageHeader("FAILURE", "F02", "Service:"+USER_LOGIN+" and exception is:"+pidsException));
		return responseMap;
	}
	}

	private boolean authenticateUser(User user) {
		List<User> userList=userService.findByDeviceId(user.getDeviceId());
		if(userList.size()==1){
			if(userList.get(0).getPassword().equals(user.getPassword()) &&
					userList.get(0).getMobile().equals(user.getMobile())){
				/*checking and assigning the results to gobal variable*/
				userEntity=userList.get(0);
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false; 
		}
	}

	private boolean validateRequestDetails(User user) {
		if(user.getDeviceId()!=null && user.getMobile()!=null && user.getPassword()!=null)
		{
			return true;
		}
		else{
			return false;
		}
	}

	private User createObjectWithData(User user) {
		User newUserObject = new User();
		newUserObject.setDeviceId(user.getDeviceId());
		newUserObject.setEmailId(user.getEmailId());
		newUserObject.setPassword(user.getPassword());
		newUserObject.setUserrole("C");
		newUserObject.setCreateDate(new Date());
		newUserObject.setLastupdateDate(new Date());
		newUserObject.setLastloginDate(new Date());
		newUserObject.setLogincount(new BigDecimal(0));

		/*Creating a blank record in user_details table and address_details table*/
		AddressDetail addressDetailObj=new AddressDetail();
		addressDetailObj.setUser(newUserObject);
		List<AddressDetail> addressDetailsList=new ArrayList<AddressDetail>();
		addressDetailsList.add(addressDetailObj);
		newUserObject.setAddressDetails(addressDetailsList);
		return newUserObject;
	}


	/*public static void main(String[] args) {
		UserLoginController obj=new UserLoginController();
		System.out.println(obj.generateUniqueString());
	}*/
}
