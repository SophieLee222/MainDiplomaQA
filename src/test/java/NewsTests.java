// NewsTests.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsTests extends PrepareTests {

    private static final String NEWS_TITLE = "Your new salary";
    private static final String NEWS_CATEGORY = "Зарплата";
    private static final String NEWS_DESCRIPTION = "You receive salary twice a month";

    @Test
    public void addNewsTest() {
        click(mobile.allNewsText);
        click(mobile.editNewsBtn);
        click(mobile.addNewsBtn);

        type(mobile.chooseCategory, NEWS_CATEGORY);
        type(mobile.addTitle, NEWS_TITLE);

        click(mobile.addPublicationDate);
        click(mobile.popupSaveBtn);

        click(mobile.addPublicationTime);
        click(mobile.popupSaveBtn);

        type(mobile.addDescription, NEWS_DESCRIPTION);
        click(mobile.saveNewsBtn);

        waitShort().until(driver ->
                !mobile.newsTitles.isEmpty()
        );

        List<WebElement> titles = mobile.newsTitles;
        WebElement last = titles.get(titles.size() - 1);
        Assertions.assertEquals(NEWS_TITLE, last.getText());
    }

    @Test
    public void deleteNewsTest() {
        click(mobile.allNewsText);
        click(mobile.editNewsBtn);

        String firstBefore = mobile.newsTitles.get(0).getText();
        click(mobile.deleteNewsBtn);

        click(mobile.popupSaveBtn);

        waitShort().until(driver ->
                !mobile.newsTitles.isEmpty() &&
                        !mobile.newsTitles.get(0).getText().equals(firstBefore)
        );

        String firstAfter = mobile.newsTitles.get(0).getText();
        Assertions.assertNotEquals(firstBefore, firstAfter);
    }
}