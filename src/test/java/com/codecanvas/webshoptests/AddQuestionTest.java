package com.codecanvas.webshoptests;

import com.codecanvas.webshop.POM.AddQuestionPom;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
        aqp = new AddQuestionPom();
    }

    @AfterEach
    public void quit() {
        // aqp.quitDriver();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/questions.csv", numLinesToSkip = 1)
    public void addNewQuestion(String title, String details, String image) {
        aqp.fillForm(title, details, image);
        aqp.submitForm();
        home = new HomePom();
        home.sort("Time", "Descending");
        String valueFromTable = home.getTableFieldValue(0,2);
        assertEquals(title, valueFromTable);
    }
}
