import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class AppLogin {

    private AndroidDriver driver;
    private MobileObjects mobileObjects;

    private static final String validLogin = "login2";
    private static final String invalidLogin = "abc";
    private static final String validPassword = "password2";
    private static final String invalidPassword = "qwe";

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        desiredCapabilities.setCapability("appium:platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Name");
        desiredCapabilities.setCapability("appium:packageName", "ru.iteco.fmhandroid");
        desiredCapabilities.setCapability("appium:activityName", "ru.iteco.fmhandroid.ui.AppActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");

        driver = new AndroidDriver(this.getUrl(), desiredCapabilities);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void validLoginTest() {
        mobileObjects.login.isDisplayed();
        mobileObjects.login.click();
        mobileObjects.login.sendKeys(validLogin);

        mobileObjects.password.isDisplayed();
        mobileObjects.password.click();
        mobileObjects.password.sendKeys(validPassword);

        mobileObjects.loginBtn.isDisplayed();
        mobileObjects.loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(mobileObjects.allNewsText));
        Assertions.assertEquals("ALL NEWS", mobileObjects.allNewsText.getText());
    }

    @Test
    public void invalidLoginTest() {
        mobileObjects.login.isDisplayed();
        mobileObjects.login.click();
        mobileObjects.login.sendKeys(invalidLogin);

        mobileObjects.password.isDisplayed();
        mobileObjects.password.click();
        mobileObjects.password.sendKeys(validPassword);

        mobileObjects.loginBtn.isDisplayed();
        mobileObjects.loginBtn.click();

        mobileObjects.loginBtn.isDisplayed();
        Assertions.assertEquals("SIGN IN", mobileObjects.loginBtn.getText());
    }

    @Test
    public void invalidPasswordTest() {
        mobileObjects.login.isDisplayed();
        mobileObjects.login.click();
        mobileObjects.login.sendKeys(validLogin);

        mobileObjects.password.isDisplayed();
        mobileObjects.password.click();
        mobileObjects.password.sendKeys(invalidPassword);

        mobileObjects.loginBtn.isDisplayed();
        mobileObjects.loginBtn.click();

        mobileObjects.loginBtn.isDisplayed();
        Assertions.assertEquals("SIGN IN", mobileObjects.loginBtn.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

