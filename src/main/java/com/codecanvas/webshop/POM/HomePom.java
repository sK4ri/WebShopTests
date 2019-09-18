package com.codecanvas.webshop.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePom extends Page{

    private final String PATH = "/";

    @CacheLookup
    @FindBy(id = "login") private WebElement loginButton;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"header_box\"]/div[2]/a[1]") private WebElement userProfileLink;

    public HomePom() {
        PageFactory.initElements(driver, this);
        goToPage(PATH);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoggedInUsername() {
        return userProfileLink.getAttribute("href");
    }
}
