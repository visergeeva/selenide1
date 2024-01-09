import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void SolutionTest() {
        open("https://github.com/");
        $(".header-menu-wrapper").find(byText("Solutions")).hover();
        $$("[aria-labelledby='solutions-for-heading'] li").first().$("a").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}