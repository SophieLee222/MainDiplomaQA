import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Login\"]")
    public WebElement login;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
    public WebElement password;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/enter_button")
    public WebElement loginBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/all_news_text_view")
    public WebElement allNewsText;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/authorization_image_button")
    public WebElement accountBtn;

    @AndroidFindBy(id = "android:id/title")
    public WebElement logoutBtn;


    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}


