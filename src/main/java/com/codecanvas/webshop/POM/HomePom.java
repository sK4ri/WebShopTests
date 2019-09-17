package com.codecanvas.webshop.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePom extends Page {

    @FindBy(id = "login")
    private WebElement loginLogout;

    public HomePom() {
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        loginLogout.click();
    }

    public boolean logoutSuccessful() {
        return loginLogout.getText().equals("LOGIN");
    }

}
