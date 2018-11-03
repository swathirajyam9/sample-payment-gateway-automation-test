package com.bddTests.page_object;

import com.bddTests.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends DriverHelper {

    @FindBy(css = ".add-to-trolley-main button")
    private WebElement addToTrolleyBtn;

    @FindBy(css = ".button.button--full.xs-hidden.sm-block")
    private WebElement goToTrolleyBtn;

    public void addToTrolley() {
        addToTrolleyBtn.click();
        sleep(2000);
    }

    public void goToTrolley() {
        goToTrolleyBtn.click();
        sleep(5000);
    }
}
