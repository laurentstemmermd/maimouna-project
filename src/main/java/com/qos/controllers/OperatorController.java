package com.qos.controllers;

import com.qos.models.Site;
import com.qos.services.LoginService;
import com.qos.services.daos.SiteDao;
import java.util.List;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class OperatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);
        
        private final LoginService loginService = new LoginService();
        @Resource
        private SiteDao siteDao;

        @RequestMapping(value = "/operator/index", method = RequestMethod.GET)
	public String operatorIndex(HttpServletRequest request, Model model) {
		List<Site> sites = siteDao.getAllSites();
                model.addAttribute("sites", sites);
                return "operator/index";
	}
}
