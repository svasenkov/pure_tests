package app.pure.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Page should have title \"Shameless hookup dating app\"")
    void titlePageTests() {
        open("https://pure.app");

        $(".intro-title").shouldHave(
                text("SHAMELESS HOOKUP DATING"));
    }

    @Test
    @DisplayName("Login with Google/Apple buttons should appear in center of page")
    void externalAuthButtonsCenterTests() {
        open("https://pure.app");

        $(".ios.login-button").shouldBe(visible);
        $(".android.login-button").shouldBe(visible);

        // should be in different test, but e2e tests are expensive
        $(".navbar-buttons__download.ios").shouldNotBe(visible);
        $(".navbar-buttons__download.android").shouldNotBe(visible);
    }

    @Test
    @DisplayName("Login with Google/Apple buttons should appear in navbar")
    void externalAuthButtonsNavbarTests() {
        open("https://pure.app");

        $("#announcement-form").scrollTo();
        $(".navbar-buttons__download.ios").shouldBe(visible);
        $(".navbar-buttons__download.android").shouldBe(visible);
    }


    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("https://pure.app");

        // assert on SEVERE
    }
}
