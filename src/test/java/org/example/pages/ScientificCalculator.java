package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScientificCalculator extends BaseCalculator{

    public ScientificCalculator(WebDriver driver) {
        super(driver);
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

}
