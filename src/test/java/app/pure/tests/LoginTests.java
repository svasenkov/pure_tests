package app.pure.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static app.pure.config.ConfigHelper.getGooglePassword;
import static app.pure.config.ConfigHelper.getGoogleUsername;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Authorization")
@Story("Log in")
@Tag("web")
public class LoginTests extends TestBase {
    @Test
    @AllureId("1615")
    @Tag("smoke")
    @Description("Authorization data stored in src/test/resources/config/authorization.properties")
    @DisplayName("Successful login Google account")
    void loginWithGoogle() {
        open("");

        $(".android.login-button").click();
        googleAuthPage.login(getGoogleUsername(), getGooglePassword());

        $(by("data-test-id", "onboarding-geolocation-access")).shouldBe(visible);
    }
}
