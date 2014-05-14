package com.qos;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, ModelMap modelMap) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
                Cookie cookie = new Cookie("user", username);
                cookie.setMaxAge(3600);
		response.addCookie(cookie);
		return "redirect:/";
	}
        
        	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
                System.out.print("logout");
                Cookie cookie = new Cookie("user", null);
                cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "redirect:/";
	}
	
}
