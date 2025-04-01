package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSection = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSection = $("#hobbiesWrapper"),
            pictureUploadInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCitySection = $("#stateCity-wrapper"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            submitButton = $("#submit"),
            modalPopup = $(".modal-dialog"),
            modalPopupHeader = $(".modal-title"),
            resultsTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderSection.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesSection.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureUploadInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.click();
        stateCitySection.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.click();
        stateCitySection.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkSuccessSubmit() {
        modalPopup.should(appear);
        modalPopupHeader.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public void checkNoSubmit() {
        modalPopup.shouldNot(appear);
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
}
