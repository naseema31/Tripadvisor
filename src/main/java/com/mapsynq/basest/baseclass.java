package com.mapsynq.basest;


import com.mapsynq.helper.browserconfiguration.ChromeBrowser;
import com.mapsynq.helper.browserconfiguration.FirefoxBrowser;
import com.mapsynq.helper.logger.LoggerHelper;
import com.mapsynq.helper.resource.ResourceHelper;
import com.mapsynq.helper.wait.WaitHelper;
import com.mapsynq.webeventlistener.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class baseclass extends baseUtil{
    public static WebDriver driver = null;
    public static Properties prop;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static DesiredCapabilities desired;
    private final static String WEBDRIVER_MODE_LOCAL = "local";
    private final static String WEBDRIVER_MODE_GRID = "grid";
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger log = LoggerHelper.getLogger(baseclass.class);
    public static File reportDirectery;



    public baseclass() {

        reportDirectery = new File(ResourceHelper.getResourcePath("src\\test\\java\\Screenshot"));
        try {
            prop = new Properties();

           FileInputStream ip = new FileInputStream(ResourceHelper.getResourcePath("\\src\\test\\resources\\config.properties")); //"E:\\QuantumInvention\\Mapsynq\\src\\test\\resources\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() throws InterruptedException, MalformedURLException {
        String browserName = prop.getProperty("browser");
        if (WEBDRIVER_MODE_LOCAL.equals(prop.getProperty("LOCAL_WEBDRIVER_MODE"))) {
            switch (browserName) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-gpu");
                    driver = new ChromeDriver(options);
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxBrowser firefoxbrowser = new FirefoxBrowser();
                   driver = firefoxbrowser.getFirefoxDriver(firefoxbrowser.getFirefoxOptions());
                    break;
                case IE:
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    File file = new File(prop.getProperty("InternetExplorerDriverPath"));
                    System.setProperty("webdriver.ie.driver","E:\\QuantumInvention\\Mapsynq\\src\\main\\java\\com\\mapsynq\\driver\\IEDriverServer.exe");
                   // driver= new InternetExplorerDriver(capabilities);
                    break;
                default:
                    throw new RuntimeException("Please Enter a Valid Browser Name");
            }
        } else if (WEBDRIVER_MODE_GRID.equals(prop.getProperty("GRID_WEBDRIVER_MODE"))) {

            if (browserName.equalsIgnoreCase("chrome")) {
                //WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.WINDOWS);
                //option.merge(capability);
                String HUBURL = "http://192.168.10.47:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL),capability);


            } else if (browserName.equalsIgnoreCase("firefox")) {
                log.info("Firefox Browser Launched");
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.WINDOWS);
                FirefoxOptions option = new FirefoxOptions();
                option.merge(capability);
                String HUBURL = "http://192.168.10.47:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL), option);


            } else if (browserName.equalsIgnoreCase("ie")) {
                log.info("IE Browser Launched");
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("internet explorer");
                capability.setPlatform(Platform.WINDOWS);
                InternetExplorerOptions option = new InternetExplorerOptions();
                option.merge(capability);
                String HUBURL = "http://192.168.10.47:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL), option);

            }
            else {
                throw new RuntimeException("Invalid Browser Name");
            }

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("URL"));
        WaitHelper.PageWait(6000);
    }

    public String captureScreen(String fileName, WebDriver driver){
        if(driver == null){
            log.info("driver is null..");
            return null;
        }
        if(fileName==""){
            fileName = "blank";
        }
        Reporter.log("captureScreen method called");
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            destFile = new File(reportDirectery+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
            Files.copy(screFile.toPath(), destFile.toPath());
            Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return destFile.toString();
    }


       public String getReportConfigPath() {
            String reportConfigPath = prop.getProperty("reportConfigPath");
            if (reportConfigPath != null) return reportConfigPath;
            else
                throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
        }
    public static void logExtentReport(String s1){

    }
    }


