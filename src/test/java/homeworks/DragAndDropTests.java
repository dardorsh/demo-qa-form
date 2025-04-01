package homeworks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void checkDragAndDropWithActions() {
        SelenideElement firstBlock = $("#column-a");
        SelenideElement secondBlock = $("#column-b");

        open("https://the-internet.herokuapp.com/drag_and_drop");
        firstBlock.shouldHave(text("A"));
        secondBlock.shouldHave(text("B"));

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDrop(firstBlock, secondBlock).perform();

        firstBlock.shouldHave(text("B"));
        secondBlock.shouldHave(text("A"));
    }

    @Test
    public void checkDragAndDropWithSelenideCommand() {
        //тут инфо для себя - https://selenide.org/javadoc/current/com/codeborne/selenide/SelenideElement.html#dragAndDrop(com.codeborne.selenide.DragAndDropOptions)
        SelenideElement firstBlock = $("#column-a");
        SelenideElement secondBlock = $("#column-b");

        open("https://the-internet.herokuapp.com/drag_and_drop");
        firstBlock.shouldHave(text("A"));
        secondBlock.shouldHave(text("B"));

        firstBlock.dragAndDrop(DragAndDropOptions.to(secondBlock));

        firstBlock.shouldHave(text("B"));
        secondBlock.shouldHave(text("A"));




    }
}
