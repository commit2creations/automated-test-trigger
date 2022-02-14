package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pages.Calculator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitions {
    WebDriver driver;
    WebDriverWait waiter;
    Calculator calculator;
    @Given("that we are on the calculator page")
    public void openCalculatorPage() {
        System.setProperty("webdriver.edge.driver", "[Enter Driver Location]");
        System.setProperty("webdriver.chrome.driver", "[Enter Driver Location]");
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://classcalc.com/scientific-calculaor");
        calculator = new Calculator(driver, waiter);
    }

    @When("I {string} {int} and {int} together")
    public int arithmeticFunctions(String arithmetic, int first, int second) {

        calculator.clickNumber(first);
        driver.findElement(new By.ById("button-" + arithmetic)).click();
        calculator.clickNumber(second);
        return first + second;
    }

    @Then("I should see {int} as the result")
    public void verifyResult(int first) {
        assertThat(driver.findElement(new By.ByCssSelector("#guppy-text-render-9 > span > span.katex-mathml > math > semantics > annotation")).getAttribute("innerHTML").trim())
                .isEqualTo("2");
        assertThat(calculator.getAnswer())
                .isEqualTo("2");
    }
}
