package com.qos.services;

import com.qos.models.Parser;
import com.qos.models.Site;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author stemlaur
 */
public class SiteService {
    
    private static final List<Site> sites;
    
    static {
        List<Site> s =  new ArrayList<Site>();
        s.add(new Site("Orange site", "admin123", Parser.CSV));
        s.add(new Site("SFR Site", "operator123", Parser.XML));
        sites = Collections.unmodifiableList(s);
    }
    
    public List<Site> getAllSites() {
        return sites;
    }
    
    public Site getSite(String name) {
        for(Site s : sites) {
            if(s.getName().equals(name))
                return s;
        }
        return null;
    }
}
