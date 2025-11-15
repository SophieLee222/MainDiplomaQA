package tests;// tests.NewsTests.java

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static data.Data.NEWS_TITLE;

public class NewsTests extends PrepareTests {

    @Test
    public void addNewsTest() {
        steps.openNewsEditor();
        String actualTitle = steps.addNews();
        Assertions.assertEquals(NEWS_TITLE, actualTitle);
    }

    @Test
    public void deleteNewsTest() {
        steps.openNewsEditor();

        String firstBefore = steps.deleteFirstNews();
        String firstAfter = mobile.newsTitles.get(0).getText();

        Assertions.assertNotEquals(firstBefore, firstAfter);
    }
}