package com.demoqa.ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.ui.forms.SubmitModalForm;
import com.demoqa.ui.helpers.Attachments;
import com.demoqa.ui.models.Student;
import com.demoqa.ui.pages.PracticeForm;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Проверка формы регистрации студента. Запуск в Jenkins")
    public void testValidStudentRegistration() {
        SelenideLogger.addListener("allure",new AllureSelenide());
        Student testStudent = new Student();

        step("Заполняем форму студента",() -> {
            new PracticeForm()
                    .open("/automation-practice-form")
                    .fillForm(testStudent)
                    .submit();
        });

        step("Проверка заведенной формы",() -> {
            new SubmitModalForm()
                    .studentForm().shouldHave(text("Thanks for submitting the form"),
                            text(testStudent.getFirstName()),
                            text(testStudent.getLastName()),
                            text(testStudent.getEmail()),
                            text(testStudent.getAddress()),
                            text(testStudent.getMobile()),
                            text(testStudent.getGender()),
                            text(testStudent.getHobbies().get(0)),
                            text(testStudent.getAddress()));
        });
    }
}
