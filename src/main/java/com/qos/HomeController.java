package com.qos;

import com.qos.models.Site;
import com.qos.models.User;
import com.qos.services.LogService;
import com.qos.services.LoginService;
import com.qos.services.SiteService;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        

        private final LoginService loginService = new LoginService();
        private final SiteService siteService = new SiteService();
        private final LogService logService = new LogService();

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, ModelMap modelMap) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
        
        @RequestMapping(value = "/operator/index", method = RequestMethod.GET)
	public String operatorIndex(HttpServletRequest request, Locale locale, Model model, ModelMap modelMap) {
		List<Site> sites = siteService.getAllSites();
                request.setAttribute("sites", sites);
                return "operator/index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
            User u = loginService.login(username, password);
            if(u == null) {
                response.setStatus( 403 );
                return null;
            }
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            return "redirect:/" + u.getPrivilege().toString().toLowerCase()+"/index";
	}
        
        @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletResponse response) {
            Cookie cookie = new Cookie("user", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return "redirect:/";
	}
	
}
