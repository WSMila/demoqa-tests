package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Yuriy");
        $("#userEmail").setValue("test@test.qa");
        $("#currentAddress").setValue("Street");
        $("#permanentAddress").setValue("Avenue");
        $("#submit").click();

        $("#output").shouldHave(text("Yuriy"), text("test@test.qa"), text("Street"), text("Avenue"));


    }
}
