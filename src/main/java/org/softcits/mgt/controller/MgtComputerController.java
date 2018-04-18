package org.softcits.mgt.controller;

import javax.servlet.http.HttpServletRequest;

import org.softcits.mgt.service.MgtComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/computer")
public class MgtComputerController {

	@Autowired
	private MgtComputerService mgtComputerService;
	
	@Value("${pc.upload.path}")
	private String pc_upload_path;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public ResponseEntity<String> getAll(){
		return new ResponseEntity<>(mgtComputerService.getComputers(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ResponseEntity<String> addComputer(@RequestParam String tradeMark, @RequestParam String price, @RequestParam("pic")MultipartFile multipartFile, HttpServletRequest req){
		
		System.out.println(tradeMark + ' ' + price + ' ' + multipartFile.getOriginalFilename());
		String realPath = req.getSession().getServletContext().getRealPath(pc_upload_path);
		System.out.println(realPath);
		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}
}
