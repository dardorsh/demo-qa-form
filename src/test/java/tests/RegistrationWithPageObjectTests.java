package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivanna")
                .setLastName("Ivanova")
                .setEmail("ivanova@mail.com")
                .setGender("Female")
                .setUserNumber("7989898890")
                .setDateOfBirth("1", "January", "1980")
                .setSubjects("English")
                .setHobbies("Reading")
                .setPicture("image.jpeg")
                .setAddress("Some address")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .submitForm()
                .checkSuccessSubmit()
                .checkResult("Student Name", "Ivanna Ivanova")
                .checkResult("Student Email", "ivanova@mail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7989898890")
                .checkResult("Date Of Birth", "01 January,1980")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Address", "Some address")
                .checkResult("State and city", "Uttar Pradesh Lucknow");
    }

    @Test
    void registrationWithMinimumDataTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setUserNumber("7989898890")
                .submitForm()
                .checkSuccessSubmit()
                .checkResult("Student Name", "John Doe")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7989898890");
    }

    @Test
    void unsuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setEmail("test@test.com")
                .submitForm()
                .checkNoSubmit();
    }
}
