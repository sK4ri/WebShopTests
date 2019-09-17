package com.codecanvas.webshop.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPagePom extends Page {

    private final String PATH = "/user_page";

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"user_page\"]/div[1]/h1") private WebElement usernameField;

    public UserPagePom() {

        PageFactory.initElements(driver, this);
        goToPage(PATH);
    }

    public String getUserName() {
        return usernameField.getText();
    }
}
