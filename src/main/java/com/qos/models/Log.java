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
    
    private final String message;
    private final LogLevel level;
    private final DateTime date;
    
    
    public Log(LogLevel level, String message, DateTime date) {
        this.message = message;
        this.level = level;
        this.date = date;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date.toString("YYYYMMdd hh:mm:ss");
    }
    
}
