package com.bddTests.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverHelper {

    protected static WebDriver driver;
    private String browser = System.getProperty("brows");
    private String url = System.getProperty("url");
   // private String remoteURL = System.getProperty("remoteURL");

    //private String browser = "chrome";

    public DriverHelper()
    {
        PageFactory.initElements(driver,this);

    }

    public void openBrowser() throws MalformedURLException {
        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
               // driver = new RemoteWebDriver(new URL(remoteURL), capabilities);// for executing on remote
                driver = new ChromeDriver(); // for executing tests on local
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;

            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    public void closeBrowser() {
        //driver.quit();
    }


   /* public void navigateTo(String url){
        driver.get(url);
    }*/

     public void navigateTo() {
        driver.get(url);
    }


    public void maxBrowser(){
        driver.manage().window().maximize();
    }

    public void applyImpWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleCookeis(){
        driver.findElement(By.linkText("GOT IT")).click();
    }

    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        } catch (WebDriverException e) {
            System.out.println("Error during screen shot");
        }
    }
}

/* We will get exception with
  driver = new RemoteWebDriver(new URL(remoteURL), capabilities);
  surround with try n catch (or) choose add exception to method signature
  ----> throws MalformedURLException in DriverHelper class and also add to method signature where we invoke
  openbrowser() method ie in Hooks also
  */