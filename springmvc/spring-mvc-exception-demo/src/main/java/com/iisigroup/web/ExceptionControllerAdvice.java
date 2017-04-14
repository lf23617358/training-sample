package com.iisigroup.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iisigroup.exception.GlobalControllerException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(GlobalControllerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String runtimeExceptionHandler(GlobalControllerException runtimeException) {
		String msg = "This is catched global exceptionhandler:" + runtimeException.getMessage();
		System.out.println(msg);
		return msg;
	}

}
