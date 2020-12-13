package com.mapsynq;


import com.mapsynq.basest.baseUtil;
import com.mapsynq.basest.baseclass;
import com.mapsynq.pages.CameraPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;

public class TestCamera extends baseUtil {

    private baseUtil base;
    public static final Logger log = Logger.getLogger(TestCamera.class.getName());

    CameraPages camerapages = new CameraPages();

    public TestCamera(baseUtil base) {
        this.base = base;
        //super();
        }

        @When("^Navigate To Cameras Tab$")
        public void navigate_To_Cameras_Tab () throws Throwable {
            camerapages.navigateToCamerasTab();
            //    captureScreen("CameraTab",driver);
            log.info("Navigate to Camera Tab");
        }

        @Then("^Veriy That (\\d+) location of Singapore Having Live Traffic Camera$")
        public void veriy_That_location_of_Singapore_Having_Live_Traffic_Camera ( int TOTAL_SINGAPORE_LOCATION) throws
        Throwable {
            Assert.assertEquals(TOTAL_SINGAPORE_LOCATION, camerapages.totalLiveTrafficCamerasOfSingapore());
            log.info("Verify the total live traffic camera of Singapore");
        }
        @Then("^Verify All the Location name of singapore having Live Cameras$")
        public void verify_All_the_Location_name_of_singapore_having_Live_Cameras () throws Throwable {
            List<String> ActualLocatiion = camerapages.Actual_Location_OF_SINGAPORE_HAVING_LIVE_CAMERAS();
            List<String> ExpectedLocation = camerapages.Expected_Location_OF_SINGAPORE_HAVING_LIVE_CAMERAS();
            Assert.assertEquals(ActualLocatiion, ExpectedLocation);
            log.info("Verify all the location of singapore having live traffic cameras S");
        }
        @Then("^Veriy That (\\d+) location of Malaysia Having Live Traffic Camera$")
        public void veriy_That_location_of_Malaysia_Having_Live_Traffic_Camera ( int TOTAL_MALAYSIA_LOCATION) throws
        Throwable {
            // Assert.assertEquals(TOTAL_MALAYSIA_LOCATION,camerapages.totalLiveTrafficCamerasOfMalaysia());
            log.info("Verify the total live traffic camera of Malaysia");
        }

    }



