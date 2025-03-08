package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    String firstName = "Semen";
    String lastName = "Semenov";
    String userEmail = "semenovich@ya.com";
    String userNumber = "9989222242";
    String month = "June";
    String year = "1999";
    int day = 13;
    String subjectsInput1 = "Ma";
    String subjectsInput2 = "En";
    String fileName ="img.png";
    String file = "/src/test/resources/" + fileName;
    String currentAddress = "street 1 ";
    String state = "Haryana";
    String city = "Karnal";

    String tableValueTemplate = "//table//td[text() = '%s']//following-sibling::td";


    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void RegistrationFormTest() {
        open("automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(userEmail);

        $("[for=gender-radio-1]").click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month .react-datepicker__day--0%s".formatted(day)).click();

        $("#subjectsInput").setValue(subjectsInput1).pressEnter();
        $("#subjectsInput").setValue(subjectsInput2).pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFile(new File(System.getProperty("user.dir") + file));

        $("#currentAddress") .setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x(tableValueTemplate.formatted("Student Name")).shouldHave(text(firstName + " " + lastName));
        $x(tableValueTemplate.formatted("Student Email")).shouldHave(text(userEmail));
        $x(tableValueTemplate.formatted("Gender")).shouldHave(text("Male"));
        $x(tableValueTemplate.formatted("Mobile")).shouldHave(text(userNumber));
        $x(tableValueTemplate.formatted("Date of Birth")).shouldHave(text(day + " " + month +"," + year));
        $x(tableValueTemplate.formatted("Subjects")).shouldHave(text("Maths, English"));
        $x(tableValueTemplate.formatted("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $x(tableValueTemplate.formatted("Picture")).shouldHave(text(fileName));
        $x(tableValueTemplate.formatted("Address")).shouldHave(text(currentAddress));
        $x(tableValueTemplate.formatted("State and City")).shouldHave(text(state + " " + city));

    }
}
