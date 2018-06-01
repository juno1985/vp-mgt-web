package org.softcits.mgt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softcits.utils.CookieUtils;
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
	
	@RequestMapping(path="/setCookie",method=RequestMethod.GET)
	public void setCookie(HttpServletRequest request, HttpServletResponse response) {
		//写入cookie
		CookieUtils.setCookie(request, response, "PC_TOKEN", "123456789abc");
	}
}
