package com.codecanvas.webshop.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPom extends Page {

    private final String PATH = "/registration";

    @CacheLookup
    @FindBy(id = "username") private WebElement usernameField;

    @CacheLookup
    @FindBy(id = "password") private WebElement passwordField;

    @CacheLookup
    @FindBy(id = "password2") private WebElement password2Field;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content_wrapper\"]/div/form/button") private WebElement submitButton;

    public RegistrationPom() {

        PageFactory.initElements(driver, this);
        goToPage(PATH);
    }

    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void setPassword2(String password2) {
        password2Field.sendKeys(password2);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
