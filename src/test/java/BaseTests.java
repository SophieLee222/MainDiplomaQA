// BaseTest.java
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;


import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTests {
    protected AndroidDriver driver;
    protected MobileObjects mobile;

    // если логин нужен и в других тестах — оставьте здесь
    protected static final String VALID_LOGIN = "login2";
    protected static final String VALID_PASSWORD = "password2";

    protected URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected DesiredCapabilities caps() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appium:ensureWebviewsHavePages", true);
        dc.setCapability("appium:nativeWebScreenshot", true);
        dc.setCapability("appium:newCommandTimeout", 3600);
        dc.setCapability("appium:connectHardwareKeyboard", true);
        dc.setCapability("appium:platformName", "android");
        dc.setCapability("appium:deviceName", "Name");
        dc.setCapability("appium:packageName", "ru.iteco.fmhandroid");
        dc.setCapability("appium:activityName", "ru.iteco.fmhandroid.ui.AppActivity");
        dc.setCapability("appium:automationName", "uiautomator2");
        return dc;
    }

    @BeforeEach
    public void setUp() {
        driver = new AndroidDriver(getUrl(), caps());
        mobile = new MobileObjects(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ---- Утилиты ожиданий и действий ----
    protected WebDriverWait waitShort() {
        return new WebDriverWait(driver, 5);
    }

    protected void visible(WebElement el) {
        waitShort().until(ExpectedConditions.visibilityOf(el));
    }

    protected void click(WebElement el) {
        visible(el);
        el.click();
    }

    protected void type(WebElement el, String text) {
        visible(el);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    // ---- Общий шаг логина (чтобы не дублировать в тестах) ----
    protected void doLogin(String login, String password) {
        type(mobile.login(), login);
        type(mobile.password(), password);
        click(mobile.loginBtn);
    }

    protected void logoutIfPossible() {
        try {
            click(mobile.accountBtn);
            click(mobile.logoutBtn);
        } catch (Exception ignored) { }
    }

}