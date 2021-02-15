package app.pure.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static app.pure.helpers.DriverHelper.getConsoleLogs;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@Tag("web")
@Feature("Main page content")
public class MainPageTests extends TestBase {
    @Test
    @AllureId("1603")
    @Story("Base blocks")
    @DisplayName("Page should have title \"Shameless hookup dating app\"")
    void titlePageTest() {
        open("");

        $(".intro-title").shouldHave(
                text("SHAMELESS HOOKUP DATING"));
    }

    @Test
    @AllureId("1606")
    @Story("External authorization buttons")
    @DisplayName("Login with Google/Apple buttons should appear in center of page")
    void externalAuthButtonsCenterTests() {
        open("");

        $(".ios.login-button").shouldBe(visible);
        $(".android.login-button").shouldBe(visible);

        // should be in different test, but e2e tests are expensive
        $(".navbar-buttons__download.ios").shouldNotBe(visible);
        $(".navbar-buttons__download.android").shouldNotBe(visible);
    }

    @Test
    @AllureId("1608")
    @Story("External authorization buttons")
    @DisplayName("Login with Google/Apple buttons should appear in navbar")
    void externalAuthButtonsNavbarTests() {
        open("");

        $("#announcement-form").scrollTo();
        $(".navbar-buttons__download.ios").shouldBe(visible);
        $(".navbar-buttons__download.android").shouldBe(visible);
    }

    @Test
    @AllureId("1602")
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open main page", () -> open(""));

        step("Page should not have errors (SEVERE) in console", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}
