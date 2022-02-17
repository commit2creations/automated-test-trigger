package org.example.pages;

import org.example.enums.Arithmetic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.MalformedParametersException;

public class Calculator {
    final WebDriver driver;

    public Calculator(WebDriver driver) {
        this.driver = driver;
    }


    WebElement numberButtons(int number) {
        if (number > 9 || number < 0)
            throw new MalformedParametersException("The selected number must be between 0 and 9 inclusive.");
        return driver.findElement(new By.ById("button-" + number));
    }

    WebElement arithmeticButtons(String function) {
        return driver.findElement(new By.ById(function));
    }

    public void clickNumber(int number) {
        numberButtons(number).click();
    }

    public void operateArithmetic(String function) {
        arithmeticButtons(function).click();
    }

    public String getAnswer() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(new By.ByCssSelector("#guppy-text-render-9 > span > span.katex-mathml > math > semantics > annotation")).getAttribute("innerHTML").trim();
    }




}
