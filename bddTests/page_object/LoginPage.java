package com.bddTests.page_object;

import com.bddTests.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class LoginPage extends DriverHelper {


    public void goToRegister() {
        driver.findElement(By.linkText("Register")).click();
    }


    public void doRegister(List<Map<String,String>> data) {
        driver.findElement(By.id("email-address"))
                .sendKeys(data.get(0).get("email"));
        driver.findElement(By.xpath("//form[@class='sign-in-form']")).click();
        new Select(driver.findElement(By.id("title")))
                .selectByVisibleText(data.get(0).get("title"));
        driver.findElement(By.id("first-name"))
                .sendKeys(data.get(0).get("first_Name"));
        driver.findElement(By.id("last-name")).sendKeys("");
        driver.findElement(By.id("postcode")).sendKeys("");

    }
}
