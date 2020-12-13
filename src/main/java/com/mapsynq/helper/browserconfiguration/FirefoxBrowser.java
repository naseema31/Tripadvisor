package com.mapsynq.helper.browserconfiguration;

import com.mapsynq.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxBrowser  {
    public FirefoxOptions getFirefoxOptions() {
        File pathBinary = new File("D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        DesiredCapabilities desired = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--headless");
        options.addArguments("test-type=browser");
        options.addArguments("window-size=1366x768");

        return options;
    }

    public WebDriver getFirefoxDriver(FirefoxOptions cap) {

        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\driver\\geckodriver"));
            return new FirefoxDriver(cap);
        } else if (System.getProperty("os.name").contains("Window")) {
            System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\driver\\geckodriver.exe"));
            return new FirefoxDriver(cap);
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
            return new FirefoxDriver(cap);
        }
        return null;
    }

}
