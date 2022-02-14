package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.MalformedParametersException;
import java.time.Duration;

public class Calculator {
    final WebDriver driver;
    final WebDriverWait waiter;

    public Calculator(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
        this.waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(new By.ByTagName("iframe")));
    }

    @FindBy(css = "#guppy-text-render-9 > span > span.katex-mathml > math > semantics > annotation")
    WebElement answer;

    WebElement numberButtons(int number) {
        if (number > 9 || number < 0)
            throw new MalformedParametersException("The selected number must be between 0 and 9 inclusive.");
        return driver.findElement(new By.ById("button-" + number));
    }

    public void clickNumber(int number) {
        numberButtons(number).click();
    }

    public String getAnswer() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        waiter.until(ExpectedConditions.visibilityOf(answer));
        return answer.getText();
    }


}
