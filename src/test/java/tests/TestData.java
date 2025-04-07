package tests;

import utils.RandomUtils;

public class TestData {
    private static final RandomUtils randomUtils = new RandomUtils();
    public static String firstName = randomUtils.getRandomFirstName(),
            lastName = randomUtils.getRandomLastName(),
            userEmail = randomUtils.getRandomEmail(),
            gender = randomUtils.getRandomGender(),
            userNumber = randomUtils.getRandomPhoneNumber(10),
            dayOfBirth = randomUtils.getRandomDay(),
            monthOfBirth = randomUtils.getRandomMonth(),
            yearOfBirth = randomUtils.getRandomYear(),
            subject = randomUtils.getRandomSubject(),
            hobby = randomUtils.getRandomHobby(),
            picture = "image.jpeg",
            userAddress = randomUtils.getRandomAddress(),
            state = randomUtils.getRandomState(),
            city = randomUtils.getRandomCity(state);
}
