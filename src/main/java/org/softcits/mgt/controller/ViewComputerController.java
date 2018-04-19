package org.softcits.mgt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class ViewComputerController {

	@RequestMapping(path="/main", method=RequestMethod.GET)
	public String goAdminView() {
		return "admin";
	}
}
