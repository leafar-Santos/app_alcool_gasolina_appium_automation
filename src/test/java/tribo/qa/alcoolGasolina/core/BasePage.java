package tribo.qa.alcoolGasolina.core;

import org.openqa.selenium.By;

import static tribo.qa.alcoolGasolina.core.DriverFactory.getDriver;

public class BasePage {

    public void insertValue(By by, String text){
        getDriver().findElement(by).sendKeys(text);
    }

    public void clickButton(By by){
        getDriver().findElement(by).click();
    }

    public String assertResult(By by){
        return getDriver().findElement(by).getText();
    }
}
