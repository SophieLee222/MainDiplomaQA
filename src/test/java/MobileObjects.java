import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class MobileObjects {

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/login_text_input_layout")
    private WebElement loginLayout;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/password_text_input_layout")
    private WebElement passwordLayout;

    public WebElement login() {
        return loginLayout.findElement(By.className("android.widget.EditText"));
    }

    public WebElement password() {
        return passwordLayout.findElement(By.className("android.widget.EditText"));
    }

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/enter_button")
    public WebElement loginBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/all_news_text_view")
    public WebElement allNewsText;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/authorization_image_button")
    public WebElement accountBtn;

    @AndroidFindBy(id = "android:id/title")
    public WebElement logoutBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/our_mission_image_button")
    public WebElement ourMissionBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/our_mission_title_text_view")
    public WebElement ourMissionTitle;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/our_mission_item_title_text_view")
    public WebElement firstQuote;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/our_mission_item_open_card_image_button")
    public WebElement firstQuoteArrow;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/our_mission_item_description_text_view")
    public WebElement firstQuoteFullText;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/edit_news_material_button")
    public WebElement editNewsBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/add_news_image_view")
    public WebElement addNewsBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_category_text_auto_complete_text_view")
    public WebElement chooseCategory;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_title_text_input_edit_text")
    public WebElement addTitle;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_date_text_input_edit_text")
    public WebElement addPublicationDate;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement popupSaveBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_publish_time_text_input_edit_text")
    public WebElement addPublicationTime;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_description_text_input_edit_text")
    public WebElement addDescription;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/save_button")
    public WebElement saveNewsBtn;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/news_item_title_text_view")
    public List<WebElement> newsTitles;

    @AndroidFindBy(id = "ru.iteco.fmhandroid:id/delete_news_item_image_view")
    public WebElement deleteNewsBtn;


    private AppiumDriver driver;

    public MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}


