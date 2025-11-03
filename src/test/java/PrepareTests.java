import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class PrepareTests extends BaseTests {

    @BeforeEach
    public void loginBeforeEach() {
        // Сначала сработает BaseTest.setUp(), потом это — порядок JUnit 5
        doLogin(VALID_LOGIN, VALID_PASSWORD);
        // при желании можно дождаться главного экрана:
        visible(mobile.allNewsText);
    }

    @AfterEach
    public void logoutAfterEach() {
        logoutIfPossible();
    }
}
