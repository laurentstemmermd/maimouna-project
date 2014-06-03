/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.models;

import java.util.Map;

/**
 *
 * @author stemlaur
 */
public class Stat {
    
    private Map<LogStatus, Integer> statuses;

    public Stat( Map<LogStatus, Integer> statuses) {
        this.statuses = statuses;
    }

    public Map<LogStatus, Integer> getStatuses() {
        return statuses;
    }

}
