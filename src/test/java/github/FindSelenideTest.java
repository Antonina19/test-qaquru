package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {
    @Test
    void shouldFindSelenideRepository() {
        // открыть страничку в гитхаб
        open("https://github.com/");
        // ввести в поле поиска selenide
        // нажать enter
        $("[name=q]").setValue("selenide").pressEnter();
        // выбрать первый найденный проект из списка (кликнуть)
        $$(".repo-list li").first().$("a").click();
        // проверка: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));

        //Selenide.sleep(5000);

    }
}
