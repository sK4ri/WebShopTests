package com.codecanvas.webshop.POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends Page{

    private final String PATH = "/login";

    @CacheLookup
    @FindBy(name = "username") private WebElement usernameInputField;

    @CacheLookup
    @FindBy(name = "plain_text_password") private WebElement passwordInputField;


    public LoginPom() {

        PageFactory.initElements(driver, this);
        goToPage(PATH);
    }

    public void login(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password + Keys.RETURN);
    }
}
