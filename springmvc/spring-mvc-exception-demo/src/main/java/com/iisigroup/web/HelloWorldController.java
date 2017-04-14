package com.iisigroup.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iisigroup.exception.GlobalControllerException;
import com.iisigroup.exception.LocalControllerException;

@Controller
public class HelloWorldController {

	@RequestMapping("testEx")
	public String helloWorld(@RequestParam(value = "isLocal", defaultValue = "true") boolean isLocal) {
		if (isLocal)
			throw new LocalControllerException("this is test exception message");
		else
			throw new GlobalControllerException("this is test exception message");
	}

	@ExceptionHandler(LocalControllerException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String runtimeExceptionHandler(LocalControllerException runtimeException) {
		String msg = "This is catched local exceptionhandler:" + runtimeException.getMessage();
		System.out.println(msg);
		return msg;
	}

}
