package com.cybertek.step_definitions;

import com.cybertek.pages.LyftFareEstimatePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LyftFareEstimate_StepDefs {

    //declare here so that we can use in each method below
    LyftFareEstimatePage fareEstimatePage = new LyftFareEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Lyft fare estimate page is not displayed", expectedTitle, actualTitle);
    }

    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickUpLocation) {
        //need to add a page object class for the Lyft estimate page
        //LyftFareEstimatePage fareEstimatePage = new LyftFareEstimatePage();

        //fareEstimatePage.pickUp.sendKeys(pickUpLocation);

        fareEstimatePage.enterPickUpLocation(pickUpLocation);

    }

    @And("User enters {string} to drop-off address")
    public void user_enters_to_drop_address(String dropOffLocation) {
        fareEstimatePage.dropOff.sendKeys(dropOffLocation);
    }

    @And("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {
        //Actions actions = new Actions(Driver.getDriver());
        //fareEstimatePage.getEstimateBtn.click();
        //actions.moveToElement(fareEstimatePage.getEstimateBtn).doubleClick().build().perform();
        fareEstimatePage.getEstimateBtn.click();
        BrowserUtils.sleep(2);
        fareEstimatePage.getEstimateBtn.click();
        BrowserUtils.sleep(5);

    }

    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(fareEstimatePage.rideTypesHeader.isDisplayed());
        System.out.println("Lyft Estimated price and time = " + fareEstimatePage.liftPrice.getText());
    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        assertTrue("Error message is not displayed", fareEstimatePage.errorMsg.isDisplayed());
    }
}
