package com.mapsynq.helper.configreader;

/**
 * Created by asit.singh on 18-01-2019.
 */
public interface ConfigReader {
    public int getImpliciteWait();
    public int getExplicitWait();
    public int getPageLoadTime();
    public BrowserType getBrowserType();
    public String getUrl();
    public String getUserName();
    public String getPassword();
}
