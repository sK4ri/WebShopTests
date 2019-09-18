package com.codecanvas.webshop.POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class AddQuestionPom extends Page{

    private final String PATH = "/add-a-question";
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

        PageFactory.initElements(driver, this);
//        login();

    }

    public void goToPageStart() {

        waiter.waitForPageLoadComplete(driver);
    }

    public void fillForm(String title, String details, String image) {
        waiter.waitForElementToBeDisplayed(questionTitle, driver);
        questionTitle.sendKeys(title);
        questionDetails.sendKeys(details);
        imageLink.sendKeys(image);
    }
    public void submitForm() {
        submitButton.click();
    }

}
