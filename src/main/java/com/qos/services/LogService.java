/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.qos.services;

import com.qos.models.Log;
import com.qos.models.LogLevel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author stemmer
 */
public class LogService {
    private static final DateTime DATE_A = DateTime.now().minusWeeks(3).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    private static final DateTime DATE_B = DateTime.now().minusWeeks(2).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    private static final DateTime DATE_C = DateTime.now().minusWeeks(1).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    
    private static final DateTime DATE_D = DateTime.now().minusWeeks(3).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    private static final DateTime DATE_E = DateTime.now().minusWeeks(2).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    private static final DateTime DATE_F = DateTime.now().minusWeeks(1).minusDays(new Random().nextInt(5) + 2).minusHours(new Random().nextInt(5) + 2).minusMinutes(new Random().nextInt(5) + 2).minusSeconds(new Random().nextInt(5) + 2);
    
    private static final Map<String, List<Log>> logs;
    static {
        List<Log> orangeLogs =  new ArrayList<Log>();
        orangeLogs.add(new Log(LogLevel.WARNING, "The network is slow", DATE_A));
        orangeLogs.add(new Log(LogLevel.INFO, "Everything is going fine", DATE_B));
        orangeLogs.add(new Log(LogLevel.ERROR, "Something wrong is happening !", DATE_C));
        orangeLogs.add(new Log(LogLevel.FATAL, "Can't read the log file !", DATE_D));
        
        List<Log> sfrLogs =  new ArrayList<Log>();
        sfrLogs.add(new Log(LogLevel.WARNING, "The network is slow", DATE_D));
        sfrLogs.add(new Log(LogLevel.INFO, "Everything is going fine", DATE_E));
        sfrLogs.add(new Log(LogLevel.ERROR, "Something wrong is happening !", DATE_F));
        
        Map<String, List<Log>> l =  new HashMap<String, List<Log>>();
        l.put("Orange", orangeLogs);
        l.put("SFR", sfrLogs);
        logs = Collections.unmodifiableMap(l);
    }
    
    public List<Log> getLogs(String siteName) {
        return logs.get(siteName);
    }
}
