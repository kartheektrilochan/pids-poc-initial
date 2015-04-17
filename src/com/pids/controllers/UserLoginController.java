package com.pids.controllers;

import static com.pids.utils.PidsCommonConstants.BODY;
import static com.pids.utils.PidsCommonConstants.HEADER;

import java.math.BigDecimal;
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
import com.pids.entity.User;
import com.pids.exceptions.PidsException;
import com.pids.service.IUserLoginService;

@Controller
public class UserLoginController {

	public static final String TEST_UR_REST = "/pids/rest/test";
	public static final String LOGINSERVIE_URLPATH = "/pids/rest/loginservice";
	public static final String USER_CREATE = "/pids/rest/create";
	public static final String PV_USERNAME = "username";
	public static final String PV_PASSWORD = "password";
	private final static Logger LOGGER = Logger.getLogger(UserLoginController.class);

	@Autowired
	private IUserLoginService userService;

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

	@RequestMapping(value = TEST_UR_REST, method = RequestMethod.GET)
	public @ResponseBody String testRest(
			@PathVariable(PV_USERNAME) String userName) {
		LOGGER.info("User login requested:" + userName);
		return "hi rest is working";
	}

	/*Create User-RestFul Service*/
	/*Before creating the user check for the device id is already registered in database or not
	 * 
	 * */
	
	@RequestMapping(value = USER_CREATE, method = RequestMethod.POST, headers = "content-type=application/json")
	public @ResponseBody Map<String,Object> createUser(@RequestBody Map<String,User> requestMap) {
		Map<String,Object> responseMap=new HashMap<String, Object>();
		User user=(User) requestMap.get(BODY);
		System.out.println("Rest-service called:" + USER_CREATE);
		String device_id = user.getDeviceId();
		try {
			if (device_id != null) {
				/* check for existing device id */
				List<User> existingUsers = userService.findByDeviceId(device_id);
				if (existingUsers.size() != 0) {
					System.out.println("****Creation Failed::" + device_id+ " already exists");
					throw new PidsException(PidsException.INVALID_DATA_EXCEPTION+"::Device Id already exists");
				} else {
					User newUserObject = new User();
					newUserObject.setDeviceId(device_id);
					newUserObject.setEmailId(user.getEmailId());
					newUserObject.setPassword(user.getPassword());
					newUserObject.setUserrole("C");
					newUserObject.setCreateDate(new Date());
					newUserObject.setLastupdateDate(new Date());
					newUserObject.setLastloginDate(new Date());
					newUserObject.setLogincount(new BigDecimal(0));
					userService.save(newUserObject);
					responseMap.put(BODY, newUserObject);
					responseMap.put(HEADER,new MessageHeader("SUCCESS", "S01", "User Created"));
					return responseMap;
				}
			}
		} catch (PidsException pidsexception) {
			responseMap.put(BODY, user);
			responseMap.put(HEADER,new MessageHeader("FAILURE", "F01", "Service:"+USER_CREATE+" and exception is:"+pidsexception));
			return responseMap;
		}
		return null;
	}

}
