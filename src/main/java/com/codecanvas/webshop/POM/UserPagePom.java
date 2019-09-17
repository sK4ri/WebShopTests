package com.codecanvas.webshop.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPagePom extends Page{

    @CacheLookup
    @FindBy (id = "question_info")
    private WebElement userInfo;
    @FindBy (xpath = "//h1")
    private WebElement userName;

    public UserPagePom(String user) {

        final String PATH = "user_page/" + user;
        PageFactory.initElements(driver, this);
        goToPage(PATH);
    }




}
