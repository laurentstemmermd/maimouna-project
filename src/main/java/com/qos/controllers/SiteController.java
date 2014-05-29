package com.qos.controllers;

import com.qos.models.Site;
import com.qos.services.daos.LogDao;
import com.qos.services.daos.SiteDao;
import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class SiteController {


    @Resource
    private SiteDao siteDao;
    @Resource
    private LogDao logDao;

    @RequestMapping(value = "/site/detail", method = RequestMethod.GET)
	public String siteDetail(HttpServletRequest request, @RequestParam String name, Model model) {
            Site site = siteDao.getSite(name);
            model.addAttribute("site", site);
            model.addAttribute("logs", logDao.getAllLogs(name));

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
	public String addSite(
                HttpServletRequest request,
                @RequestParam String name,
                @RequestParam String host,
                @RequestParam String userName,
                @RequestParam String password,
                @RequestParam String logPath,
                @RequestParam String logType,
                @RequestParam String connectionType) {

            if(siteDao.addSite(name, host, userName, password, logPath, logType, connectionType)) {
                return "redirect:/";
            } else {
                return "redirect:/?error=true";
            }
	}
}
