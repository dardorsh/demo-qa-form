import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class FormFillTests {

    @BeforeAll
    static void setupConfig() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormAndCheckData() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@mail.com");
        $("#gender-radio-1").sibling(0).click();
        $("#userNumber").setValue("7989898890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("C");
        $("#react-select-2-option-2").scrollTo().click();
        $("#hobbies-checkbox-2").sibling(0).click();
        $("#uploadPicture").uploadFromClasspath("image.jpeg");
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $(By.xpath("//div[text()='Uttar Pradesh']")).click();
        $("#city").click();
        $(By.xpath("//div[text()='Lucknow']")).click();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Ivan Ivanov"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("ivanov@mail.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("7989898890"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("01 January,1980"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("image.jpeg"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Some address"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Lucknow"));
    }
}
