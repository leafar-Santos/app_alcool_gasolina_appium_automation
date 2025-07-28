package tribo.qa.alcoolGasolina.core;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class BaseTest {

    @AfterEach
    public void quitDriver(){
        DriverFactory.getDriver().terminateApp("br.triboqa.alcool_ou_gasolina.MainActivity");
    }

    @AfterEach
    @DisplayName("Evidência do teste")
    public void screenshoot_test(){
        takeScreenShot();
    }

    @AfterAll
    public static void quitClass(){
        DriverFactory.KillDriver();
    }

    @DisplayName("Evidência do teste")
    public static void takeScreenShot(){
        Allure.addAttachment("Evidência do teste", new ByteArrayInputStream(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
