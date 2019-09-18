package com.codecanvas.webshop.POM;

import com.codecanvas.webshop.DriverUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

import java.util.concurrent.TimeUnit;

public class AddQuestionPom extends Page{

    private Waiter waiter = new Waiter();

    @CacheLookup
    @FindBy(id = "title") private WebElement questionTitle;
    @CacheLookup
    @FindBy(id = "message") private WebElement questionDetails;
    @CacheLookup
    @FindBy(id = "image") private WebElement imageLink;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content_wrapper\"]/div/form/p[4]/button") private WebElement submitButton;
    @CacheLookup
    @FindBy(linkText = "Back") private WebElement backButton;

    public AddQuestionPom() {
        PATH = "/add-a-question";
        this.driver = DriverUtil.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String title, String details, String image) {
        // waiter.waitForElementToBeDisplayed(questionTitle, driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        questionTitle.sendKeys(title);
        questionDetails.sendKeys(details);
        imageLink.sendKeys(image);
    }
    public void submitForm() {
        submitButton.click();
    }

}
