package com.jang.app.accounts;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@RequestMapping(value= "add", method = RequestMethod.GET)
	public void add() {
		Calendar ca = Calendar.getInstance();
		
		long l = ca.getTimeInMillis();
		String s = String.valueOf(l);
	}
}
