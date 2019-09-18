package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.AddQuestionPom;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import waiter.Waiter;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddQuestionTest {

    private static AddQuestionPom aqp;
    private static HomePom home;
    private Waiter waiter = new Waiter();

    @BeforeAll
    public static void init() {

    }
    @BeforeEach
    public void before() {
        aqp = new AddQuestionPom();
        home = new HomePom();
        aqp.goToPage();
        aqp.login();
        aqp.goToPage();
    }
    @AfterEach
    public void exit() {
        DriverUtil.quit();
    }

    @AfterAll
    public static void quit() {
        // DriverUtil.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/questions.csv", numLinesToSkip = 1)
    public void addNewQuestion(String title, String details, String image) {

        aqp.fillForm(title, details, image);
        aqp.submitForm();
        home.sort("Time", "Descending");
        String valueFromTable = home.getTableFieldValue(0,2);
        assertEquals(title, valueFromTable);
    }
}
