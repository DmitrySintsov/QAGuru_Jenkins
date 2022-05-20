package com.demoqa.ui.tests;

import com.demoqa.ui.helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

   @BeforeAll
   public static void setUp() {
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.timeout = 5000;
       Configuration.browser = "chrome";
       Configuration.browserSize = "2048x1152";

       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("enableVNC", true);
       capabilities.setCapability("enableVideo", true);
       Configuration.browserCapabilities = capabilities;
   }

    @AfterEach
    public void addAttachments() {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}



