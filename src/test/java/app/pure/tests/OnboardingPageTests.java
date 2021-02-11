package app.pure.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@Feature("Onboarding page content")
@Tag("web")
public class OnboardingPageTests extends TestBase {
    @Test
    @DisplayName("Page should have title \"Знакомства без обязательств\"")
    void titlePageTests() {
        open("");
        $(byText("Check other ads")).click(); // or go strait to page
        switchTo().window(1);

        $("#root").shouldHave(
                text("Знакомства без обязательств"));
    }
}
