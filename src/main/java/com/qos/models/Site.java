package com.qos.models;

/**
 *
 * @author stemlaur
 */
public class Site {

    private final Integer id;
    private final String name;
    private final String host;
    private final String userName;
    private final String password;
    private final String logPath;
    private final Parser logType;
    private final Connector connectionType;

    public Site(Integer id, String name, String host, String userName, String password, String logPath, Parser logType, Connector connectionType) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.userName = userName;
        this.password = password;
        this.logPath = logPath;
        this.logType = logType;
        this.connectionType = connectionType;
    }

    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getLogPath() {
        return logPath;
    }

    public Connector getConnectionType() {
        return connectionType;
    }

    public Parser getLogType() {
        return logType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }
    
    public String toString() {
        return name;
    }
    
}
