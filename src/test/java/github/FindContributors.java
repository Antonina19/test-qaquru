package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    @Test
    void firstContributorShouldBeSolntsev() {
        // открыть страничку selenide
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому элементу в области Contributors
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div")
                .$("ul li").hover();
        // проверка: в появившемся окошечке (overlay) текст Andrei Solntsev
        $$(".Popover-message").findBy(Condition.visible)
                .shouldHave(text("Andrei Solntsev"));


    }
}
