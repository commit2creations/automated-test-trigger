package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.enums.Arithmetic;
import org.example.enums.MathBranch;
import org.example.enums.ModalShould;
import org.example.pages.ScientificCalculator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitions {
    WebDriver driver;
    ScientificCalculator scientificCalculator;
    @Given("that I am on the calculator page")
    public void openCalculatorPage() {
        System.setProperty("webdriver.edge.driver", "[Enter Driver Location]");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrpro\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://classcalc.com/scientific-calculaor");
        driver.switchTo().frame(driver.findElement(new By.ByTagName("iframe")));
        scientificCalculator = new ScientificCalculator(driver);
    }

    @When("I {arithmetic} {int} and {int} together")
    public int arithmeticFunctions(Arithmetic function, int first, int second) {
        scientificCalculator.clickNumber(first);
        scientificCalculator.operateArithmetic(function.getFunction());
        scientificCalculator.clickNumber(second);
        return first + second;
    }

    @Then("I should see {word} as the result")
    public void verifyResult(String first) {
        assertThat(scientificCalculator.getAnswer())
                .isEqualTo(first);
    }
    @When("I select the number(s) {word}")
    public void selectNumbers(String numbers) {
        Stream.of(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .forEach(number -> scientificCalculator.clickNumber(number));
    }
    @When("I {arithmetic}")
    public void arithmeticFunction(Arithmetic function) {
        scientificCalculator.operateArithmetic(function.getFunction());
    }

    @Then("I {modalShould} see the exclamation point near the answer section")
    public void checkForExclamation(ModalShould auxiliary) {
        assertThat(scientificCalculator.isExclamation())
                .isEqualTo(auxiliary.getModal());
    }

    @When("I select the {mathBranch} menu")
    public void mathBranchMenu(MathBranch mathBranch){
        scientificCalculator.openMathBranchMenu(mathBranch);
    }

    @Then("I {modalShould} see {mathBranch}")
    public void mathBranchMenuWindow(ModalShould modalShould,MathBranch mathBranch){
        assertThat(scientificCalculator.isMathBranchMenuOpen(mathBranch))
                .isEqualTo(modalShould.getModal());
    }
}
