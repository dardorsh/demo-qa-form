package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationWithFakerTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        String firstName = getRandomFirstName(),
                lastName = getRandomLastName(),
                userEmail = getRandomEmail(),
                gender = getRandomGender(),
                userNumber = getRandomPhoneNumber(10),
                dayOfBirth = getRandomDay(),
                monthOfBirth = getRandomMonth(),
                yearOfBirth = getRandomYear(),
                subject = getRandomSubject(),
                hobby = getRandomHobby(),
                userAddress = getRandomAddress(),
                state = getRandomState(),
                city = getRandomCity(state);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(getRandomPicture())
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkSuccessSubmit()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date Of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth) //"01 January,1980"
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Address", userAddress)
                .checkResult("State and city", state + " " + city);
    }
}
