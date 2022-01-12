package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utilities.Driver.getDriver;

public class VyTrackDashboardPage extends BasePage{
    public  VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//li[@id= 'user-menu']/a")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logOutLink.click();
    }

}
