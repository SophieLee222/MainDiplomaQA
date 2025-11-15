package tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenElements.MobileScreenElements;
import steps.Steps;

import java.net.MalformedURLException;
import java.net.URL;


public abstract class BaseTests {
    protected AndroidDriver driver;
    protected MobileScreenElements mobile;
    protected Steps steps;


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
        mobile = new MobileScreenElements(driver);
        steps = new Steps(driver);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    protected void visible(WebElement el) {
        steps.visible(el);
    }

//    protected WebDriverWait waitShort() {
//        return steps.waitShort();
//    }
//
//    protected void click(WebElement el) {
//        steps.click(el);
//    }
//
//    protected void type(WebElement el, String text) {
//        steps.type(el, text);
//    }
}