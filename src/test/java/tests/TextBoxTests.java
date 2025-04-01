package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        String userName = "Alice Cooper";
        String userEmail = "alice@test.com";
        String[] addresses = {"Address 1", "Address 2"};

        textBoxPage.openPage()
                .setName(userName)
                .setEmail(userEmail)
                .setCurrentAddress(addresses[0])
                .setPermanentAddress(addresses[1])

                .checkOutputAppears()
                .checkOutputName(userName)
                .checkOutputEmail(userEmail)
                .checkOutputCurrentAddress(addresses[0])
                .checkOutputPermanentAddress(addresses[1]);
    }
}
