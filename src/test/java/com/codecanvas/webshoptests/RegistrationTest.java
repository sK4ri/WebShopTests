package com.codecanvas.webshoptests;

import com.codecanvas.webshop.POM.HomePom;
import com.codecanvas.webshop.POM.LoginPom;
import com.codecanvas.webshop.POM.RegistrationPom;
import com.codecanvas.webshop.POM.UserPagePom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    private static RegistrationPom registrationPom;
    private static HomePom homePom;
    private static LoginPom loginPom;
    private static UserPagePom userPagePom;


    @BeforeAll
    public static void init() {
        registrationPom = new RegistrationPom();
    }

//    @AfterEach
//    public void quit() {
//        registrationPom.quitDriver();
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "/registerdata.csv")
    public void successfulRegister(String username, String password, String password2) {

        homePom = new HomePom();
        loginPom = new LoginPom();
        userPagePom = new UserPagePom();

        registrationPom.setUsername(username);
        registrationPom.setPassword(password);
        registrationPom.setPassword2(password2);
        registrationPom.clickSubmit();
        homePom.clickLoginButton();
        loginPom.login(username, password);
        homePom.clickUserPageButton();
        assertEquals(username, userPagePom.getUserName());
    }
}
