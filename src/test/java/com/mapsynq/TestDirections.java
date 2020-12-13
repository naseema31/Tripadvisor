package com.mapsynq;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class TestDirections {
    public static final Logger log = Logger.getLogger(TestDirections.class.getName());

       @When("^User Input Current Location As \"([^\"]*)\"$")
       public void user_Input_Current_Location_As(String arg1) throws Throwable {

       }

       @When("^Target Location As \"([^\"]*)\"$")
       public void target_Location_As(String arg1) throws Throwable {

       }

       @Then("^Click On Get Directions$")
       public void click_On_Get_Directions() throws Throwable {

       }

   }
