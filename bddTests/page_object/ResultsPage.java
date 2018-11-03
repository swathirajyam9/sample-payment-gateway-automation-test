package com.bddTests.page_object;


import com.bddTests.driver.DriverHelper;
import com.bddTests.utils.UtilsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverHelper {


    @FindBy(css = ".font-condensed.search-title__term")
    private WebElement productTitleLbl;

    @FindBy(css = ".ac-facet__label")
    private List<WebElement> allFilterByWE ;

    @FindBy(css = ".ac-star-rating")
    private List<WebElement> starRatingsWE ;

    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> productPricesWE ;

    @FindBy(css = ".font-standard.form-control.sort-select")
    private WebElement sortBy;

    @FindBy(css = ".ac-product-card__name")
    private List<WebElement> allProductsWE ;

    public static String expectedProduct;

    public String getProductTitle() {
        return productTitleLbl.getText();
    }

    public void selectFilterBy(String filterChoice) {
      //  List<WebElement> filterWebElements = driver.findElements(By.cssSelector(".ac-facet__label"));
        for (WebElement filterElement : allFilterByWE) {
            if (filterElement.getText().equalsIgnoreCase(filterChoice)) {
                new WebDriverWait(driver, 20)
                        .until(ExpectedConditions.elementToBeClickable(filterElement));
                filterElement.click();
                break;
            }
        }
//        new WebDriverWait(driver, 30)
//                .until(ExpectedConditions
//                        .invisibilityOf(driver.findElement(By.cssSelector(".icon--loading"))));
        sleep(5000);
    }

    //.ac-star-rating --> after applying filter, stars within the filtered products
    // 4ormore --30prod, 5only - 14prod
    public List<Double> getAllRatingOnProducts() {
        List<Double> collectedRatingList = new ArrayList<>();
       // List<WebElement> filterWebelemts = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement filterWebelemt : starRatingsWE) {
            String ratingValueInString = filterWebelemt.getAttribute("data-star-rating");
            double ratingValueInDouble = Double.parseDouble(ratingValueInString);
            collectedRatingList.add(ratingValueInDouble);
        }
        return collectedRatingList;
    }

    //.ac-product-price__amount ---> after applying filter, pricesof filtered products
    // £10-£15--> 17 prod
    public List<Double> getAllProductsPrices() {
        List<Double> collectedPriceList = new ArrayList<>();
        System.out.println("Actual Price List: ");
       // List<WebElement> filterWebelements = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        for (WebElement filterWebelement : productPricesWE) {
            double indiPrice = Double.parseDouble(filterWebelement.getText().replace("£", ""));
            collectedPriceList.add(indiPrice);
            System.out.println(indiPrice);
        }
        return collectedPriceList;
    }

    public void selectSortingOptions(String choice) {
        Select dropDownSelect = new Select(sortBy);
        dropDownSelect.selectByVisibleText(choice);
        sleep(5000);
    }

    public String selectAnyProduct() {
       // List<WebElement> allProductsWebElement = driver.findElements(By.cssSelector(".ac-product-card__name"));
        int productCount = allProductsWE.size();

//        new WebDriverWait(driver, 30)
//                .until(ExpectedConditions
//                        .numberOfElementsToBeMoreThan(By.cssSelector(".ac-product-card__name"), 30));

        sleep(5000);
        System.out.println("total number of products count : " + productCount);
        int rdnNumber = new UtilsHelper().generateRandomNumber(productCount);

        WebElement indProduct = allProductsWE.get(rdnNumber);
        expectedProduct = indProduct.getText();
        indProduct.click();

        return expectedProduct;
    }
}
