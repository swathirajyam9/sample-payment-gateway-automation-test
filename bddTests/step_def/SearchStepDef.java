package com.bddTests.step_def;

import com.bddTests.page_object.HeaderPage;
import com.bddTests.page_object.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDef {

    private HeaderPage headerPage = new HeaderPage();
    private ResultsPage resultsPage=new ResultsPage();

    @Given("^I am on home page$")
    public void i_am_on_home_page() {
        String actual = headerPage.getCurrentPageURL();
        assertThat("User is not on homepage.",actual,is(endsWith(".co.uk/")));

    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void searchForAProduct(String searchTerm) {
        headerPage.doSearch(searchTerm);
    }


    @Then("^I should see all the product of \"([^\"]*)\"$")
    public void iShouldSeeAllTheProductOf(String expected) {
        String actual=resultsPage.getProductTitle();
        assertThat("Wrong Title",actual,is(equalToIgnoringCase(expected)));
    }
}
