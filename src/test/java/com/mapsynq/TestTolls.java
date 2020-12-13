package com.mapsynq;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.mapsynq.basest.baseclass;
import com.mapsynq.pages.TollPages;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestTolls extends baseclass {
	
	public static final Logger log = Logger.getLogger(TestTolls.class.getName());
	TollPages tollgate = new TollPages();
	  public TestTolls() { super();}
	
	@When("^Navigate To Tolls Tab$")
	public void navigate_To_Tolls_Tab() throws Throwable {
		tollgate.navigateToTollTab();
	        captureScreen("TollTab",driver);
	        log.info("Navigate to Toll Tab");
	}

	@Then("^Veriy That (\\d+) location of Singapore Having Toll Gate$")
	public void veriy_That_location_of_Singapore_Having_Toll_Gate(int TollGateCount) throws Throwable {
		Assert.assertEquals(TollGateCount,tollgate.totalCountOfTollGatesInSingapore());
    	log.info("Verify the total count of singapore location having Toll gate");
	}

	@Then("^Verify All the Location name of singapore having Toll Gate$")
	public void verify_All_the_Location_name_of_singapore_having_Toll_Gate() throws Throwable {
		 List<String> ActualLocatiion=tollgate.Actual_Location_OF_SINGAPORE_HAVING_TOLL_GATE();
	        List<String> ExpectedLocation=tollgate.Expected_Location_OF_SINGAPORE_HAVING_TOLL_GATE();
	        Assert.assertEquals(ActualLocatiion,ExpectedLocation);
	        log.info("Verify all the location of singapore having Toll Gates");
	}

	
}
