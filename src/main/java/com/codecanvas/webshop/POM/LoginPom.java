package com.codecanvas.webshop.POM;

import com.codecanvas.webshop.DriverUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends Page{

    @CacheLookup
    @FindBy(name = "username") private WebElement usernameInputField;

    @CacheLookup
    @FindBy(name = "plain_text_password") private WebElement passwordInputField;


    public LoginPom() {
        PATH = "/login";
        this.driver = DriverUtil.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password + Keys.RETURN);
    }
}
