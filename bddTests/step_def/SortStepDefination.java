package com.bddTests.step_def;

import com.bddTests.page_object.ResultsPage;
import com.google.common.collect.Ordering;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SortStepDefination {

    private ResultsPage resultsPage = new ResultsPage();

    @And("^I set sort by filter as \"([^\"]*)\"$")
    public void iSetSortByFilterAs(String sortOption) {
        resultsPage.selectSortingOptions("Price: Low - High");
    }

    @Then("^I should see all the product in sorted order as \"([^\"]*)\"$")
    public void iShouldSeeAllTheProductInSortedOrderAs(boolean expected) {
        List<Double> actual = resultsPage.getAllProductsPrices();
        boolean sorted = Ordering.natural().isOrdered(actual);
        assertThat("Price is not sorted. ", sorted, is(equalTo(true)));
    }
}
