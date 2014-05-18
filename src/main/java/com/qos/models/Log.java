/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.models;

import org.joda.time.DateTime;

/**
 *
 * @author stemmer
 */
public class Log {

    private final String service;
    private final DateTime eventDate;
    private final LogStatus status;
    private final String attempt;
    private final String statusInfo;


    public Log(String service, DateTime eventDate, LogStatus status, String attempt, String statusInfo) {
        this.service = service;
        this.eventDate = eventDate;
        this.status = status;
        this.attempt = attempt;
        this.statusInfo = statusInfo;
    }

    public String getService() {
        return service;
    }

    public DateTime getEventDate() {
        return eventDate;
    }

    public String getAttempt() {
        return attempt;
    }
    
    public boolean isOk() {
        return (status == LogStatus.OK);
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public LogStatus getStatus() {
        return status;
    }
    
    

}
