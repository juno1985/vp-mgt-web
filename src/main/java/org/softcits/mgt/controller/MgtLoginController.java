package org.softcits.mgt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softcits.mgt.service.MgtUserService;
import org.softcits.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;

@Controller
public class MgtLoginController {
	@Autowired
	private MgtUserService mgtUserService;

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
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String passwd,
			HttpServletRequest request, HttpServletResponse response) {
		
		String token = mgtUserService.login(username, passwd);
		
		if(!StringUtils.isEmpty(token)) {
			//写入cookie
			CookieUtils.setCookie(request, response, "PC_TOKEN", token);
		}
		
		return "redirect:/admin/pc";
	}
}
