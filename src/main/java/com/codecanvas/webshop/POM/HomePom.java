package com.codecanvas.webshop.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import waiter.Waiter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePom extends Page{
    private final String PATH = "/";
    private Waiter waiter = new Waiter();
    @CacheLookup
    @FindBy(id = "sort_by") private WebElement selectSortBy;
    @CacheLookup
    @FindBy(id = "sort_direction") private WebElement selectSortDirection;
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"sort\"]/form/p[3]/button") private WebElement sortButton;
    @CacheLookup
    @FindBy(id = "main_table") private WebElement questionTable;

    public HomePom() {
        PageFactory.initElements(driver, this);

    }
    public void sort(String by, String direction ) {
        Select sortBy = new Select(selectSortBy);
        Select sortDirection = new Select(selectSortDirection);
        sortBy.selectByVisibleText(by);
        sortDirection.selectByVisibleText(direction);
        sortButton.click();
    }
    public String getTableFieldValue(int rowIndex, int columnIndex) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> rows = questionTable.findElements(By.tagName("tr"));
        List<WebElement> cols = rows.get(rowIndex).findElements(By.tagName("td"));
        String cell = cols.get(columnIndex).getText();
        return cell;
    }

}
