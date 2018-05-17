package org.softcits.mgt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MgtLoginController {

	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String goLoginView() {
		return "login";
	}
	
	@RequestMapping(path="/register",method=RequestMethod.GET)
	public String goRegisterView() {
		return "register";
	}
}
