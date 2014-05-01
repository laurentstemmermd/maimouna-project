package com.qos.models;

/**
 *
 * @author stemlaur
 */
public class Site {
    
    private final String name;
    private final String path;
    private final Parser parserType;
    
    public Site(String name, String path, Parser parserType) {
        this.name = name;
        this.path = path;
        this.parserType = parserType;
    }

    public String getName() {
        return name;
    }

    public Parser getParserType() {
        return parserType;
    }

    public String getPath() {
        return path;
    }
}
