package tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public abstract class PrepareTests extends BaseTests {

    @BeforeEach
    public void loginBeforeEach() {
        steps.loginWithValidData();
        steps.waitAllNewsVisible();
    }

    @AfterEach
    public void logoutAfterEach() {
        steps.logoutIfPossible();
    }
}