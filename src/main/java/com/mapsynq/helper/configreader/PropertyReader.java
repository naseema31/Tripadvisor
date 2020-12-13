package com.mapsynq.helper.configreader;

/**
 * Created by asit.singh on 18-01-2019.
 */
public class PropertyReader  implements ConfigReader {
    @Override
    public int getImpliciteWait() {
        return 0;
    }

    @Override
    public int getExplicitWait() {
        return 0;
    }

    @Override
    public int getPageLoadTime() {
        return 0;
    }

    @Override
    public BrowserType getBrowserType() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
