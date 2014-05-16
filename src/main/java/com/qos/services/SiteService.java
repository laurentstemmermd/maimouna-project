package com.qos.services;

import com.qos.models.Parser;
import com.qos.models.Site;
import com.qos.services.daos.SiteDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author stemlaur
 */
@Service
public class SiteService {
    
    private static final List<Site> sites;
    
    @Resource
    private SiteDao siteDao;
    
    static {
        List<Site> s =  new ArrayList<Site>();
        s.add(new Site("Orange", "/tmp/log_orange.csv", Parser.CSV));
        s.add(new Site("SFR", "/tmp/log_sfr.csv", Parser.XML));
        sites = Collections.unmodifiableList(s);
    }
    
    public List<Site> getAllSites() {
        return sites;
    }
    
    public Site getSite(String name) {
        return siteDao.getSite(name);
    }
    
    public List getLogs() {
        
        return null;
    }
}
