package com.iisigroup.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;

	@RequestMapping("localetest")
	public String LocaleTest() {
		return "helloWorld";
	}

	@ResponseBody
	@RequestMapping(value = "localejsontest")
	public String LocaleJsonTest(Locale locale) {
		return messageSource.getMessage("welcome_title", null, locale);
	}

}
