import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void DragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}