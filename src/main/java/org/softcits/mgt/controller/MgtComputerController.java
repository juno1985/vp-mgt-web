package org.softcits.mgt.controller;

import org.softcits.mgt.service.MgtComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer")
public class MgtComputerController {

	@Autowired
	private MgtComputerService mgtComputerService;
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public ResponseEntity<String> getAll(){
		return new ResponseEntity<>(mgtComputerService.getComputers(),HttpStatus.OK);
	}
}
