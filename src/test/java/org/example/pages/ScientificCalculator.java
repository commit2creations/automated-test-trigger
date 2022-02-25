package org.example.pages;

import org.example.enums.MathBranch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScientificCalculator extends BaseCalculator{

    public ScientificCalculator(WebDriver driver) {
        super(driver);
    }

    private WebElement mathBranchButton(MathBranch mathBranch){
        return driver.findElement(new By.ByClassName(mathBranch.getBranch()));
    }

    private WebElement mathBranchMenu(MathBranch mathBranch){
        return driver.findElement(new By.ById(mathBranch.getBranch() + "-soft-container"));
    }
    @Override
    public String getAnswer() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(new By.ByCssSelector("#guppy-text-render-9 > span > span.katex-mathml > math > semantics > annotation")).getAttribute("innerHTML").trim();
    }

    public void openMathBranchMenu(MathBranch mathBranch){
        mathBranchButton(mathBranch).click();
    }

    public boolean isMathBranchMenuOpen(MathBranch mathBranch){
        return mathBranchMenu(mathBranch).isDisplayed();
    }

}
