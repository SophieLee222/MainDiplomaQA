// QuotesTests.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuotesTests extends PrepareTests {

    private static final String FIRST_QUOTE =
            "«Хоспис для меня - это то, каким должен быть мир.\"";
    private static final String FIRST_QUOTE_FULL =
            "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер";

    @Test
    public void quotesTest() {
        visible(mobile.ourMissionBtn);
        click(mobile.ourMissionBtn);

        visible(mobile.firstQuote);
        Assertions.assertEquals(FIRST_QUOTE, mobile.firstQuote.getText());

        click(mobile.firstQuoteArrow);
        visible(mobile.firstQuoteFullText);
        Assertions.assertEquals(FIRST_QUOTE_FULL, mobile.firstQuoteFullText.getText());
    }
}