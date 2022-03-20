package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Yuriy";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName("Gladkov");
        $("#userEmail").setValue("gladkov@ua.net");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("+380963355447");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1980");
        $("[aria-label$='June 12th, 1980']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("wsmila/1.jpg");
        $("#currentAddres").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-model-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkForm("Student Name", firstName + "Gladkov")
                .checkForm("Student Email", "gladkov@ua.net")
                .checkForm("Gender", "Other");

    }

}
