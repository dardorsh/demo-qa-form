package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private final static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomPhoneNumber(int digits) {
        return faker.number().digits(digits);
    }

    public static String getRandomDay() {
        return String.valueOf(faker.random().nextInt(1,29));
    }

    public static String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1980, 2005));
    }

    public static String getRandomSubject() {
        return faker.options().option("Maths", "Chemistry", "English", "Computer Science", "Economics");
    }
    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String getRandomPicture() {
        return faker.avatar().image();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + state);
        };
    }
}
