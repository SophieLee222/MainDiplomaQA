package tests;

import data.Data;
import org.junit.jupiter.api.*;

public class AuthTests extends BaseTests {

    @BeforeAll
    static void setUpAll() {

    }

    @BeforeEach
    public void prepare() {
        steps.clearLoginFields();
    }

    @Test
    public void validAuthTest() {
        steps.loginWithValidData();
        steps.waitAllNewsVisible();
        Assertions.assertEquals("ALL NEWS", mobile.allNewsText.getText());
    }

    @Test
    public void invalidLoginTest() {
        steps.doLogin(Data.INVALID_LOGIN, Data.VALID_PASSWORD);
        // проверка, что остались на экране логина:
        visible(mobile.loginBtn);
        Assertions.assertEquals("SIGN IN", mobile.loginBtn.getText());
    }

    @Test
    public void invalidPasswordTest() {
        steps.doLogin(Data.VALID_LOGIN, Data.INVALID_PASSWORD);
        visible(mobile.loginBtn);
        Assertions.assertEquals("SIGN IN", mobile.loginBtn.getText());
    }

    @AfterEach
    public void logoutAfterEach() {
        steps.logoutIfPossible();
    }
}