package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.MalformedParametersException;

class BaseCalculator {

    final WebDriver driver;

    BaseCalculator(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement numberButtons(int number) {
        if (number > 9 || number < 0)
            throw new MalformedParametersException("The selected number must be between 0 and 9 inclusive.");
        return driver.findElement(new By.ById("button-" + number));
    }
    private WebElement arithmeticButtons(String function) {
        return driver.findElement(new By.ById(function));
    }
    private WebElement exclamation(){
        return driver.findElement(new By.ByCssSelector("span.error-type-triangle > div > img[alt=error-triangle]"));
    }

    public void clickNumber(int number) {
        numberButtons(number).click();
    }

    public void operateArithmetic(String function) {
        arithmeticButtons(function).click();
    }

    public String getAnswer(){
        return null;
    }

    public boolean isExclamation() {
        return exclamation().isDisplayed();
    }
}
