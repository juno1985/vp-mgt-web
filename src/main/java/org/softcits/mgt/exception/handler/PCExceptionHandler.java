package org.softcits.mgt.exception.handler;

import org.softcits.mgt.exception.PCBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PCExceptionHandler {

	@ExceptionHandler(PCBadRequestException.class)
	@ResponseBody
	public ResponseEntity<String> PCBadRequestHandler(PCBadRequestException pCBadRequestException){
		String errMsg = pCBadRequestException.getMessage();
		return new ResponseEntity<String>(errMsg, HttpStatus.BAD_REQUEST);
	}
}
