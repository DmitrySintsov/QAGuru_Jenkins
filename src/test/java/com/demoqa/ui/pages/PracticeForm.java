package com.demoqa.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.ui.helpers.Dates;
import com.demoqa.ui.models.Student;
import com.demoqa.ui.pages.components.CalendarComponent;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    public PracticeForm open(String url) {

        Selenide.open(url);
        return new PracticeForm();

    }

    public PracticeForm fillForm(Student user) {

      firstName(user.getFirstName());
      lastName(user.getLastName());
      userEmail(user.getEmail());
      gender(user.getGender());
      mobile(user.getMobile());
      birthDate(Integer.toString(new Dates().getMonthDate(user.getBirthday())),
                new Dates().getMonth(user.getBirthday()),
                Integer.toString(new Dates().getYear(user.getBirthday())));
      subject(user.getSubjects());
      hobbies(user.getHobbies());
      pictureFromFile("test.png");
      currentAddress(user.getAddress());
      stateCity(user.getState(), user.getCity());

      return page(PracticeForm.class);

    }

    private void stateCity(String state, String city) {

        $("div#state").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(state)).click();

        $("div#city").scrollIntoView(true).click();
        $("div#stateCity-wrapper").$(byText(city)).click();

    }

    private void currentAddress(String value) {

        $("textarea#currentAddress").setValue(value);

    }

    private void pictureFromFile(String value) {

        $("input#uploadPicture").uploadFromClasspath(value);

    }



    private void firstName(String value) {

        $("input#firstName").setValue(value);

    }

    private void lastName(String value) {

        $("input#lastName").setValue(value);

    }

    private void userEmail(String value) {

        $("input#userEmail").setValue(value);

    }

    private void gender(String value) {

        $$(By.cssSelector("label[for^='gender-radio']"))
                .findBy(text(value))
                .click();

    }


    private void mobile(String value) {

        $("input#userNumber").setValue(value);
    }

    private void birthDate(String day, String month, String year) {

        $("input#dateOfBirthInput").click();

        new CalendarComponent()
                .setDate(day,month,year);
    }

    private void subject(List<String> value) {

        SelenideElement subject = $("input#subjectsInput");

        for(String sub : value) {
            subject.setValue(sub).pressEnter();
        }

    }

    private void hobbies(List<String> value) {

        ElementsCollection hobbies = $$(By.cssSelector("label[for^=hobbies-checkbox]"));

        for(String hobby:value) {
                 hobbies
                         .findBy(text(hobby))
                         .click();
        }

    }

    public void submit() {

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("button#submit").click();

    }

}
