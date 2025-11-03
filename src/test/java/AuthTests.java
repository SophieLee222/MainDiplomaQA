import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthTests extends BaseTests {

    private static final String INVALID_LOGIN = "abc";
    private static final String INVALID_PASSWORD = "qwe";

    @BeforeEach
    public void prepare() {
        click(mobile.login());
        mobile.login().clear();
        click(mobile.password());
        mobile.password().clear();
    }

    @Test
    public void validLoginTest() {
        doLogin(VALID_LOGIN, VALID_PASSWORD);
        visible(mobile.allNewsText);
    }

    @Test
    public void invalidLoginTest() {
        doLogin(INVALID_LOGIN, VALID_PASSWORD);
        // проверка, что остались на экране логина:
        visible(mobile.loginBtn);
        Assertions.assertEquals("SIGN IN", mobile.loginBtn.getText());
    }

    @Test
    public void invalidPasswordTest() {
        doLogin(VALID_LOGIN, INVALID_PASSWORD);
        visible(mobile.loginBtn);
        Assertions.assertEquals("SIGN IN", mobile.loginBtn.getText());
    }

    @AfterEach
    public void logoutAfterEach() {
        logoutIfPossible();
    }
}

