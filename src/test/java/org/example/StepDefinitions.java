package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.enums.Arithmetic;
import org.example.pages.Calculator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitions {
    WebDriver driver;
    Calculator calculator;
    @Given("that we are on the calculator page")
    public void openCalculatorPage() {
        System.setProperty("webdriver.edge.driver", "[Enter Driver Location]");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrpro\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://classcalc.com/scientific-calculaor");
        driver.switchTo().frame(driver.findElement(new By.ByTagName("iframe")));
        calculator = new Calculator(driver);
    }

    @When("I {arithmetic} {int} and {int} together")
    public int arithmeticFunctions(Arithmetic function, int first, int second) {
        calculator.clickNumber(first);
        calculator.operateArithmetic(function.getFunction());
        calculator.clickNumber(second);
        return first + second;
    }

    @Then("I should see {word} as the result")
    public void verifyResult(String first) {
        assertThat(calculator.getAnswer())
                .isEqualTo(first);
    }
}
