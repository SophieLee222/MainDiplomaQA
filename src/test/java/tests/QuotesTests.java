package tests;// tests.QuotesTests.java

import data.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuotesTests extends PrepareTests {

    @Test
    public void quotesTest() {
        steps.openOurMission();
        visible(mobile.firstQuote);
        Assertions.assertEquals(Data.FIRST_QUOTE, mobile.firstQuote.getText());

        steps.openFirstQuote();
        Assertions.assertEquals(Data.FIRST_QUOTE_FULL, mobile.firstQuoteFullText.getText());
    }
}