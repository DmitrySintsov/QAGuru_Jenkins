package com.demoqa.ui.tests;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

   @BeforeAll

    public static void setUp() {

       Configuration.browser = "chrome";
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.timeout = 5000;
       Configuration.browserSize = "2048x1152";

       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("enableVNC", true);
       capabilities.setCapability("enableVideo", true);
       Configuration.browserCapabilities = capabilities;
   }

}



