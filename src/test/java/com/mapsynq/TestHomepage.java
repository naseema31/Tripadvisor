package com.mapsynq;


import com.mapsynq.basest.baseUtil;
import com.mapsynq.basest.baseclass;
import com.mapsynq.helper.assertion.AssertionHelper;
import com.mapsynq.pages.CameraPages;
import com.mapsynq.pages.Homepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class TestHomepage extends baseUtil {
    public static final Logger log = Logger.getLogger(TestHomepage.class.getName());
    private baseUtil base;
    baseclass basec = new baseclass();
    Homepage homepage = new Homepage(); ;



    public TestHomepage(baseUtil base) {
        this.base=base;
        //super();
    }

    @Given("^Launch Browser And Application$")
    public void launch_Browser_And_Application() throws Throwable {
        basec.initialization();
    }

    @When("^User In Homepage$")
    public void user_In_Homepage() throws Throwable {

        basec.captureScreen("Homepage",driver);
    }

    @Then("^Validate Application Title$")
    public void validate_Application_Title() throws Throwable {
        String Title="mapSYNQ - Live Traffic Information Platform";
        Assert.assertEquals(homepage.ValidatePageTitle(),Title);
    }

    @Then("^Close all browser$")
    public void close_all_browser() throws Throwable {
        base.driver.quit();
    }

    @When("^User In Homepage and Search \"([^\"]*)\"$")
    public void user_In_Homepage_and_Search(String Search) throws Throwable {
        homepage.searchItem(Search);
    }

}
