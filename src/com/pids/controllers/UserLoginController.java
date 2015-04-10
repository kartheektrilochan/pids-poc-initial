package com.pids.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pids.entity.User;
import com.pids.service.IUserLoginService;

@Controller
public class UserLoginController {
	
	public static final String TEST_UR_REST="/pids/rest/test";
	public static final String LOGINSERVIE_URLPATH="/pids/rest/loginservice";
	public static final String USER_CREATE="/pids/rest/create";
	public static final String PV_USERNAME="username";
	public static final String PV_PASSWORD="password";
	private final static Logger LOGGER = Logger.getLogger(UserLoginController.class); 
	
	@Autowired
	private IUserLoginService userService;
	
	/*@RequestMapping(value=LOGINSERVIE_URLPATH, method = RequestMethod.GET)
	public ModelAndView getDetails(@ModelAttribute("command") User user) {
		System.out.println("Calling service controller");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  userService.getUserDetails(user));
		return new ModelAndView("employeesList", model);
	}*/
	
	
	@RequestMapping(value=LOGINSERVIE_URLPATH+"/{"+PV_USERNAME+"}",
			method = RequestMethod.GET)
	
	public @ResponseBody String checkLoginDetails(
			@PathVariable(PV_USERNAME) String userName) {
		System.out.println("calling checklogindetails method");
		LOGGER.info("User login requested:"+userName);
		User user=new User();
		user.setUsername(userName);
		userService.getUserDetails(user);
		return "hi";
	}
	
	@RequestMapping(value=TEST_UR_REST,
			method = RequestMethod.GET)
	
	public @ResponseBody String testRest(
			@PathVariable(PV_USERNAME) String userName) {
		LOGGER.info("User login requested:"+userName);
	return "hi rest is working";
	}

	@RequestMapping(value=USER_CREATE,
			method = RequestMethod.POST,headers="content-type=application/json")
	public @ResponseBody User createUser(
			@RequestBody  User user) {
		System.out.println("called");
		System.out.println(user.getId());
		LOGGER.info("User login requested:"+user.getUsername());
		User newuser=new User();
		newuser.setMobilenumber("7411415955");
		newuser.setUsername("kkt");
		newuser.setMiddlename("abc");
		//newuser.setUsername(user.getUsername());
		newuser.setAddress1("abd");
		newuser.setId("1");
		userService.save(newuser);
		return user;
	}

	

}
