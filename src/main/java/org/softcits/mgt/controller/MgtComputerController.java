package org.softcits.mgt.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.softcits.mgt.service.MgtComputerService;
import org.softcits.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.softcits.mgt.auth.AuthClass;
import org.softcits.mgt.auth.AuthMethod;
import org.softcits.mgt.model.MbgComputer;
@AuthClass
@RestController
@RequestMapping("/admin/pc")
public class MgtComputerController {

	@Autowired
	private MgtComputerService mgtComputerService;
	
	@Value("${pc.upload.path}")
	private String pc_upload_path;
	@AuthMethod(roleId="1,3")
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public ResponseEntity<String> getAll(@RequestParam String pageNum, @RequestParam String rows){
		return new ResponseEntity<>(mgtComputerService.getComputers(pageNum,rows),HttpStatus.OK);
	}
	@AuthMethod(roleId="1,3")
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public ResponseEntity<String> addComputer(@RequestParam String tradeMark, @RequestParam String price, @RequestParam("pic")MultipartFile multipartFile, HttpServletRequest req) throws IOException{
		
		if(!multipartFile.isEmpty()) {
			String realPath = req.getSession().getServletContext().getRealPath(pc_upload_path);
			//得到上传文件名
			String fileName = multipartFile.getOriginalFilename();
			
			//得到上传文件的扩展名
			String fileExt = FilenameUtils.getExtension(fileName);
			
			//生成新的文件名,避免上传文名重复从而发生覆盖
			String newFileName = UUIDUtil.UUIDGenerator() + '.' + fileExt;
			
			//创建本地实体文件
			//F:\git-repo\SpringWeb\src\main\webapp\resources\pic + "\" + "Logo.png" 
			File file = new File(realPath + "//" + newFileName);
			
			//实现文件的上传拷贝
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
			
			String result = mgtComputerService.addComputer(tradeMark, price, newFileName);
			
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("必须上传文件", HttpStatus.OK);
	}
	@AuthMethod(roleId="1,2,3")
	@RequestMapping(path= {"/",""}, method=RequestMethod.GET)
	public ModelAndView goAdminView() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
	@AuthMethod(roleId="1,3")
	@RequestMapping(path="/query/{id}", method=RequestMethod.GET)
	public ResponseEntity<String> queryById(@PathVariable String id){
		String computerStr = mgtComputerService.queryComputerById(id);
		return new ResponseEntity<String>(computerStr, HttpStatus.OK);
	}
	@AuthMethod(roleId="1,3")
	@RequestMapping(path="/update",method=RequestMethod.POST)
	public ResponseEntity<String> update(@RequestParam(required=false) String cid,@RequestParam(required=false) String tradeMark, @RequestParam(required=false) String price){
		MbgComputer mbgComputer = new MbgComputer();
		mbgComputer.setId(Integer.parseInt(cid));
		mbgComputer.setPrice(Float.parseFloat(price));
		mbgComputer.setTrademark(tradeMark);
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
}
