package app.pure.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static app.pure.helpers.DriverHelper.getConsoleLogs;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;


@Feature("Onboarding page content")
@Tag("web")
public class OnboardingPageTests extends TestBase {

    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        open("");
        $(byText("Check other ads")).click();
        switchTo().window(1);

        $("#root").shouldHave(
                text("THE ANONYMOUS HOOKUP APP"));
    }

    @Test
    @DisplayName("Page should have title \"THE ANONYMOUS HOOKUP APP\"")
    void titlePageTest() {
        open("/app/ru/onboarding");

        $("#root").shouldHave(
                text("THE ANONYMOUS HOOKUP APP"));
    }

    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open onboarding page", () -> open("/app/ru/onboarding"));

        step("Page should not have errors (SEVERE) in console", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}
