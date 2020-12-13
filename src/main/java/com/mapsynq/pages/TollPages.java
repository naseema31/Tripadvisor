package com.mapsynq.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.basest.baseclass;
import com.mapsynq.helper.excelutility.excelUtility;
import com.mapsynq.helper.resource.ResourceHelper;

public class TollPages extends baseclass {
	public static final Logger log = Logger.getLogger(TollPages.class.getName());

    @FindBy(xpath = "//*[@id='erp_locationsingapore']/li")
    List<WebElement> TOLL_GATE_OF_SINGAPORE;

    @FindBy(xpath = "//*[@id='erp_locationsingapore']/li")
    List<WebElement> TOTAL_MALAYSIA_LIVE_TRAFFIC_CAMERAS;

    @FindBy(xpath = "//*[contains(text(),'Tolls')]")
    private  WebElement TollsTAB;
    
    public TollPages() {
        PageFactory.initElements(driver, this);
       
    }

    public void navigateToTollTab(){
    	TollsTAB.click();
        log.info("Navigate to Toll Tab...");
   }
    
    public int totalCountOfTollGatesInSingapore(){
        int count=TOLL_GATE_OF_SINGAPORE.size();
        return count;
        
    }

    public int totalLiveTrafficCamerasOfMalaysia(){
        int count=TOTAL_MALAYSIA_LIVE_TRAFFIC_CAMERAS.size();
        return count;
    }

    /*
     * Fetch Expected Location of Singapore having toll gate
     */
    
    public List<String> Actual_Location_OF_SINGAPORE_HAVING_TOLL_GATE() throws InterruptedException {
        List<String> Location_Name = new ArrayList<String>();
        for (WebElement ele : TOLL_GATE_OF_SINGAPORE) {
            String TOLLGATE_LOCATION_Name_OF_SINGAPORE = ele.getAttribute("innerText").trim();
            Thread.sleep(200);
            Location_Name.add(TOLLGATE_LOCATION_Name_OF_SINGAPORE);
        }
        return Location_Name;
    }

    /*
     * Fetch Actual Location of Singapore having toll gate
     */
    public  List<String> Expected_Location_OF_SINGAPORE_HAVING_TOLL_GATE() {
        excelUtility reader = new excelUtility(ResourceHelper.getResourcePath("\\src\\main\\java\\com\\mapsynq\\helper\\testdata\\Testdata.xlsx"));
        List<String> Location_Name1 = new ArrayList<String>();
        int rowcount = reader.getRowCount("SecondSheet");
        for (int rownum = 2; rownum <= rowcount; rownum++) {
        Location_Name1.add(reader.getCellData("SecondSheet", "Singapore_Toll_Location", rownum));

        }
        return Location_Name1;
    }


    
	
}
