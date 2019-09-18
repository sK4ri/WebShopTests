package com.codecanvas.webshoptests;

import com.codecanvas.webshop.DriverUtil;
import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseQuestionsTest {

    private static HomePom hp;
    private static LoginPom lp;

    @BeforeEach
    public void init() {
        hp = new HomePom();
        lp = new LoginPom();
        lp.goToPage();
        lp.login(lp.SELENIUM_USERNAME, lp.SELENIUM_PASSWORD);
    }

    @AfterEach
    public void quit() {
        DriverUtil.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/question_contents.csv")
    public void browseQuestions(String question) {
        assertTrue(hp.questionIsFound(question));
    }

}
