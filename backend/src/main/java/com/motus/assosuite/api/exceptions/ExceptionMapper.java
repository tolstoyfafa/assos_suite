package com.motus.assosuite.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleAllExceptions(BusinessException exc){
		ErrorResponse response = new ErrorResponse(exc.getMessage(), exc.getCode().getCode());
		return new ResponseEntity<ErrorResponse>(response, exc.getCode().getStatus());
	}

}
