package com.bddTests.page_object;

import com.bddTests.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TrolleyPage extends DriverHelper {


    @FindBy(css = ".description>strong>a")
    private WebElement productInBasket;


    public String getProdcutInBasket() {
        return productInBasket.getText();
    }

    public void collect(String postcode) {
        driver.findElement(By.cssSelector("")).sendKeys(postcode);
    }

    public void chooseStore() {
        driver.findElement(By.cssSelector("")).click();
    }
}
