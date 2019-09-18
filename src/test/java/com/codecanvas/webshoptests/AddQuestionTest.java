package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.AddQuestionPom;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddQuestionTest {

    private static AddQuestionPom aqp;
    private static HomePom hp;
    private static LoginPom lp;

    @BeforeEach
    public void init() {
        aqp = new AddQuestionPom();
        hp = new HomePom();
        lp = new LoginPom();
        lp.goToPage();
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
        aqp.goToPage();
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/questions.csv", numLinesToSkip = 1)
    public void addNewQuestion(String title, String details, String image) {
        aqp.fillForm(title, details, image);
        aqp.submitForm();
        hp.sort("Time", "Descending");
        String valueFromTable = hp.getTableFieldValue(0,2);
        assertEquals(title, valueFromTable);
    }
}
