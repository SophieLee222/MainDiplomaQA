package steps;


import data.Data;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenElements.MobileScreenElements;

import java.time.Duration;
import java.util.List;

import static data.Data.*;

public class Steps {
    private final AppiumDriver driver;
    private final WebDriverWait wait;
    private final MobileScreenElements el;


    public Steps(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.el = new MobileScreenElements(driver);
    }


    // Actions
    public WebDriverWait waitShort() {
        return wait;
    }

    public void visible(WebElement e) {
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e) {
        visible(e);
        e.click();
    }

    public void type(WebElement e, String text) {
        visible(e);
        e.click();
        e.clear();
        e.sendKeys(text);
    }


    // Auth (экран авторизации)
    public void doLogin(String login, String password) {
        type(el.login(), login);
        type(el.password(), password);
        click(el.loginBtn);
    }

    public void loginWithValidData() {
        doLogin(Data.VALID_LOGIN, Data.VALID_PASSWORD);
    }

    // Clear login fields
    public void clearLoginFields() {
        click(el.login());
        el.login().clear();
        click(el.password());
        el.password().clear();
    }


    // Header
    public void openOurMission() {
        visible(el.ourMissionBtn);
        click(el.ourMissionBtn);
    }

    public void logoutIfPossible() {
        try {
            click(el.accountBtn);
            click(el.logoutBtn);
        } catch (Exception ignored) {
        }
    }


    // Main page
    public void waitAllNewsVisible() {
        visible(el.allNewsText);
    }


    // Quotes
    public void openFirstQuote() {
        click(el.firstQuoteArrow);
        visible(el.firstQuoteFullText);
    }


    // News page and Control panel
    public void openNewsEditor() {
        click(el.allNewsText);
        click(el.editNewsBtn);
    }

    public String addNews() {
        click(el.addNewsBtn);

        type(el.chooseCategory, NEWS_CATEGORY);
        type(el.addTitle, NEWS_TITLE);

        click(el.addPublicationDate);
        click(el.popupSaveBtn);

        click(el.addPublicationTime);
        click(el.popupSaveBtn);

        type(el.addDescription, NEWS_DESCRIPTION);
        click(el.saveNewsBtn);

        waitShort().until(driver ->
                !el.newsTitles.isEmpty()
        );

        List<WebElement> titles = el.newsTitles;
        WebElement last = titles.get(titles.size() - 1);
        return last.getText();
    }


    public String deleteFirstNews() {
        String firstBefore = el.newsTitles.get(0).getText();
        click(el.deleteNewsBtn);

        click(el.popupSaveBtn);

        waitShort().until(driver ->
                !el.newsTitles.isEmpty() &&
                        !el.newsTitles.get(0).getText().equals(firstBefore)
        );
        return firstBefore;
    }


    // Доступ к элементам при необходимости
    public MobileScreenElements elements() {
        return el;
    }
}