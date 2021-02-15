package app.pure.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static app.pure.config.ConfigHelper.getGooglePassword;
import static app.pure.config.ConfigHelper.getGoogleUsername;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class LoginTests extends TestBase {
    @Test
    void loginWithGoogle() {
        open("");

        $(".android.login-button").click();
        googleAuthPage.login(getGoogleUsername(), getGooglePassword());

        $(by("data-test-id", "onboarding-geolocation-access")).shouldBe(visible);
    }
}
