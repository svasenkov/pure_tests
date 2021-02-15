package app.pure.pages.external;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;


public class GoogleAuthPage {
    private final static SelenideElement
            googleMainDiv = $("#initialView"),
            googleEmailInput = $("#identifierId"),
            googlePasswordInput = $("[name='password']"),
            googleNextButton = $("[id$='Next']");

    @Step("Authorization with google")
    public void login(String username, String password) {
        googleEmailInput.setValue(username);
        googleNextButton.click();
        googlePasswordInput.setValue(password);
        googleNextButton.click();

        googleMainDiv.should(disappear);
    }
}
