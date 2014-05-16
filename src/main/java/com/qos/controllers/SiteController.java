package com.qos.controllers;

import com.qos.models.Site;
import com.qos.services.LogService;
import com.qos.services.LoginService;
import com.qos.services.daos.SiteDao;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class SiteController {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
        
        private final LoginService loginService = new LoginService();
        @Resource
        private SiteDao siteDao;
        private final LogService logService = new LogService();

        @RequestMapping(value = "/site/detail", method = RequestMethod.GET)
	public String siteDetail(HttpServletRequest request, @RequestParam String name, Model model) {
            Site site = siteDao.getSite(name);
            model.addAttribute("site", site);
            return "site/index";
	}
        
        @RequestMapping(value = "/site/delete", method = RequestMethod.GET)
	public String removeSite(HttpServletRequest request, @RequestParam String name) {
            if(siteDao.removeSite(name)) {
                return "redirect:/";
            } else {
                return "redirect:/?error=true";
            }
	}
        
        
        @RequestMapping(value = "/site/new", method = RequestMethod.POST)
	public String addSite(HttpServletRequest request, @RequestParam String name, @RequestParam String path, @RequestParam String type) {
            if(siteDao.addSite(name, path, type)) {
                return "redirect:/";
            } else {
                return "redirect:/?error=true";
            }
	}
}
