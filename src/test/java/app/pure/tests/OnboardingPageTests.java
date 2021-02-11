package app.pure.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@Tag("web")
public class OnboardingPageTests {
    @Test
    @DisplayName("Page should have title \"Знакомства без обязательств\"")
    void titlePageTests() {
        open("https://pure.app");
        $(byText("Check other ads")).click(); // or go strait to page
        switchTo().window(1);

        $("#root").shouldHave(
                text("Знакомства без обязательств"));
    }
}
