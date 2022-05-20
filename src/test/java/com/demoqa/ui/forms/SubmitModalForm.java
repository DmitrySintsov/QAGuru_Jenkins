package com.demoqa.ui.forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class SubmitModalForm {

    public SelenideElement title() {

      return $("div#example-modal-sizes-title-lg").shouldBe(Condition.visible);

    }

    public SelenideElement studentForm() {

        return $("div.modal-content").shouldBe(Condition.visible);

    }

}
