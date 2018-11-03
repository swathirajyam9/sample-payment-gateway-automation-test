package com.bddTests.step_def;

import com.bddTests.page_object.ProductDescriptionPage;
import com.bddTests.page_object.ResultsPage;
import com.bddTests.page_object.TrolleyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class BasketStepDef {
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescriptionPage descriptionPage = new ProductDescriptionPage();
    private TrolleyPage trolleyPage = new TrolleyPage();

    @And("^I select a product from results$")
    public void iSelectAProductFromResults() {
        resultsPage.selectAnyProduct();
    }

    @And("^I add product to basket$")
    public void iAddProductToBasket() {
        descriptionPage.addToTrolley();
    }

    @And("^I go to basket$")
    public void iGoToBasket() {
        descriptionPage.goToTrolley();
    }

    @Then("^I should see selected product in the basket$")
    public void iShouldSeeSelectedProductInTheBasket() {
        String expected = ResultsPage.expectedProduct;
        String actual = trolleyPage.getProdcutInBasket();

        assertThat("Wrong product in basket. ", actual, is(equalToIgnoringCase(expected)));
    }
}
