package com.qos.controllers;

import com.qos.models.User;
import com.qos.services.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
        
        private final LoginService loginService = new LoginService();
        
        private static Cookie getCookie(HttpServletRequest request, String name) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (cookie.getName().equals(name)) {
                        return cookie;
                    }
                }
            }

            return null;
        }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
            Cookie cookie = getCookie(request, "user");
            if(cookie == null)
                return "home";
            else {
                User u = loginService.getUser(cookie.getValue());
                return "redirect:/" + u.getPrivilege().toString().toLowerCase()+"/index";
            }
	}
        
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
            User u = loginService.login(username, password);
            if(u == null) {
                response.setStatus( 403 );
                return "redirect:/?error=true";
            }
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return "redirect:/";
	}
        
        @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse response) {
            Cookie cookie = new Cookie("user", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return "redirect:/";
	}
	
}
