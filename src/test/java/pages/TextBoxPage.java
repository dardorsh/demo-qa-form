package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.Text;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement nameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputSection = $("#output"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setName(String value) {
        nameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkOutputAppears() {
        outputSection.should(appear);

        return this;
    }

    public TextBoxPage checkOutputName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOutputPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}
