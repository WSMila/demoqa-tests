package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarCpmponents;

import java.net.CacheRequest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    private CalendarCpmponents calendarCpmponents = new CalendarCpmponents();
    // locators
    private  SelenideElement
            headerTitel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitel.shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);

    }
    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarCpmponents.setDate(day, month, year);

    }
    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

 /*   public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    } */
}
