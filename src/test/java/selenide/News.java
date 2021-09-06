package selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class News {
    @Test
        //@DisabledIfSystemProperty()
        //@EnabledIfSystemProperty()
    void clipborads() {
        open("https://moskva.mts.ru/personal");
        Selenide.clipboard().setText("123432424");
        $("name=number").sendKeys(Keys.COMMAND + "v");
        $("name=number").shouldHave(value("(123) 432-42-34"));
    }

    @Test
    void ownTextTest() {
        open("https://github.com");
        $("home-code h3").shouldHave(ownText("cord"));
    }

    void snapshotTest() {
        ElementsCollection checkboxes = $$("checkbox").filter(visible);
        for (int i = 0; i < 10; i++) {
            checkboxes.get(i).shouldBe(enabled);
        }

        ElementsCollection checkboxesFast = $$("checkbox").filter(visible).snapshot();
        for (int i = 0; i < 10; i++) {
            checkboxesFast.get(i).shouldBe(enabled);
        }

        ElementsCollection collection = $$("").snapshot();
        collection.get(4).shouldHave(text("abc"));
        $("button").click();
        collection.get(5).shouldHave(text("abc"));
    }
}
