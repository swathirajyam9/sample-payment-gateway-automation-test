package com.bddTests.step_def;

import com.bddTests.page_object.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

public class FilterStepDef {

    private ResultsPage resultsPage = new ResultsPage();


    @And("^I apply filter \"([^\"]*)\" on search result$")
    public void iApplyFilterOnSearchResult(String filterValue) {
        resultsPage.selectFilterBy(filterValue);
    }


    @Then("^I should see all the filtered products \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iShouldSeeAllProductsAreFiltered(String filter, String filterValue) {
        if (filter.equalsIgnoreCase("review")) {
            List<Double> actual = resultsPage.getAllRatingOnProducts();
            assertThat("List is storing wrong value",
                    actual, everyItem(greaterThanOrEqualTo(Double.parseDouble(filterValue))));
        }
        if (filter.equalsIgnoreCase("range")) {
            List<Double> actual = resultsPage.getAllProductsPrices();
            List<String> rangeList = Arrays.asList(filterValue.split("-"));
            Double min = Double.parseDouble(rangeList.get(0));
            Double max = Double.parseDouble(rangeList.get(1));
            assertThat(actual, everyItem(is(both(greaterThanOrEqualTo(min)).and(lessThanOrEqualTo(max)))));
        }

    }
}

// filterValue.split("-")--> returns  String array after split.
// Arrays.asList(string array)--> converts String array to List
// public static List<String> asList(String[] a) -> method sig
