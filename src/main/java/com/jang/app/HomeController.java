package com.jang.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println("Main");
		// 하위에서 -> 상위 o 가능함
		// 상위에서 -> 하위는 X 불가능
		HttpSession session = request.getSession();
		
		
//		Cookie[] cookies = request.getCookies();
//		
//		for(Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
		
//		Cookie cookie = new Cookie("test", "JDG");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);
//		
		
		return "index";
	}
	
}
