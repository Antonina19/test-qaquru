package guru.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void setup() {
        baseUrl = "https://demoqa.com";
        startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@qaguru.com");
        $("#currentAddress").setValue("some street 1");
        $("#permanentAddress").setValue("another street 2");
        $("#submit").click();

        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("alex@qaguru.com"));
        $("#currentAddress", 1).shouldHave(text("some street 1"));
        $("p#permanentAddress").shouldHave(text("another street 2"));

    }
}
