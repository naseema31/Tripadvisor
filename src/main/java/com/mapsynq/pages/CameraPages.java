package com.mapsynq.pages;


import com.mapsynq.basest.baseclass;
import com.mapsynq.helper.excelutility.excelUtility;
import com.mapsynq.helper.resource.ResourceHelper;
import cucumber.api.java.en.Given;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class CameraPages extends baseclass {
	public static final Logger log = Logger.getLogger(CameraPages.class.getName());

    @FindBy(xpath = "//*[@id=\"camera_location_singapore\"]/li")
    List<WebElement> TOTAL_SINGAPORRE_LIVE_TRAFFIC_CAMERAS;

    @FindBy(xpath = "//*[@id=\"camera_location_malaysia\"]/li")
    List<WebElement> TOTAL_MALAYSIA_LIVE_TRAFFIC_CAMERAS;

    @FindBy(xpath = "//*[@class='ui-button-text']//h2[text()='Cameras']")
    private  WebElement CAMERAS_TAB;



    public CameraPages() {
        PageFactory.initElements(driver, this);
       
    }

    public void navigateToCamerasTab(){
           CAMERAS_TAB.click();
           log.info("Navigate to Camera Tab...");

      }
  
    public int totalLiveTrafficCamerasOfSingapore(){
        int count=TOTAL_SINGAPORRE_LIVE_TRAFFIC_CAMERAS.size();
        return count;
        
    }

    public int totalLiveTrafficCamerasOfMalaysia(){
        int count=TOTAL_MALAYSIA_LIVE_TRAFFIC_CAMERAS.size();
        return count;
    }

    /*
     * Fetch Expected Location of Singapore having live traffic cameras
     */
    
    public List<String> Actual_Location_OF_SINGAPORE_HAVING_LIVE_CAMERAS() throws InterruptedException {
        List<String> Location_Name = new ArrayList<String>();
        for (WebElement ele : TOTAL_SINGAPORRE_LIVE_TRAFFIC_CAMERAS) {
            String SINGAPORE_LOCATION_Name = ele.getAttribute("innerText").trim();
            Thread.sleep(200);
            Location_Name.add(SINGAPORE_LOCATION_Name);
        }
        return Location_Name;
    }

    /*
     * Fetch Actual Location of Singapore having live traffic cameras
     */
    public  List<String> Expected_Location_OF_SINGAPORE_HAVING_LIVE_CAMERAS() {
        excelUtility reader = new excelUtility(ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\helper\\testdata\\Testdata.xlsx"));
        List<String> Location_Name1 = new ArrayList<String>();
        int rowcount = reader.getRowCount("FirstSheet");
        for (int rownum = 2; rownum <= rowcount; rownum++) {
        Location_Name1.add(reader.getCellData("FirstSheet", "Singapore_Live_Camera_ Location", rownum));

        }
        return Location_Name1;
    }




}
