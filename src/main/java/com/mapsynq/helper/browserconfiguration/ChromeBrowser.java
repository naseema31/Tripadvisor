package com.mapsynq.helper.browserconfiguration;

import com.mapsynq.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by asit.singh on 18-01-2019.
 */
public class ChromeBrowser {

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        //options.addArguments("--headless");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-extensions");
        options.addArguments("test-type=browser");
        options.addArguments("window-size=1366x768");
        options.addArguments("disable-infobars");
        return options;
    }

    public WebDriver getChromeDriver(ChromeOptions cap) {
        if (System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\driver\\chromedriver.exe"));
            return new ChromeDriver(cap);
        }
        else if(System.getProperty("os.name").contains("Window")){
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\driver\\chromedriver.exe"));
            return new ChromeDriver(cap);
        }
        else if(System.getProperty("os.name").contains("Linux")){
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chrome");
            return new ChromeDriver(cap);
        }
        return null;
    }

  /*  public static void main(String[] args) {
        ChromeBrowser obj = new ChromeBrowser();
        WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
        driver.get("https://www.zomato.com/bangalore/punjabi-nawabi-hsr/order/LoqDdXx");
    }*/
}
