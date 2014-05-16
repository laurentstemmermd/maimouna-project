/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos;

import com.qos.services.daos.SiteDao;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author stemlaur
 */
@Controller
@SessionAttributes({"user"})
public class SiteController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    
    @Resource
    private SiteDao siteDao;
    
    @RequestMapping(value = "/operator/site/detail", method = RequestMethod.GET)
    public String home(@RequestParam String name, Locale locale, Model model, ModelMap modelMap) {
            logger.info("Welcome home! The client locale is {}.", locale);

            model.addAttribute("site", siteDao.getSite(name) );

            return "site/index";
    }
        
}
