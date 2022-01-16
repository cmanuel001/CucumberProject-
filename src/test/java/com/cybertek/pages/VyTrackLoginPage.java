package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utilities.BrowserUtils.sleep;
import static com.cybertek.utilities.Driver.getDriver;

public class VyTrackLoginPage extends BasePage{


    @FindBy(name = "_username")
    public WebElement _username;

    @FindBy(name = "_password")
    public WebElement _password;

    @FindBy(id = "_submit")
    public WebElement loginBtn;


    public void login(String user, String pass){
  _username.sendKeys(user);
        _password.sendKeys(pass);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginBtn.click();



    }


        }




