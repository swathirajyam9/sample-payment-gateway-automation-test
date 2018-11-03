package com.bddTests.step_def;

import com.bddTests.page_object.HeaderPage;
import com.bddTests.page_object.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class RegisterStepDef {


    private HeaderPage headerPage=new HeaderPage();
    private LoginPage loginPage=new LoginPage();

    @When("^I navigate to register page$")
    public void i_navigate_to_register_page() {
        headerPage.goToLoginPage();
        loginPage.goToRegister();

    }

    @When("^I fill the user registeration for:$")
    public void i_fill_the_user_registeration_for(List<Map<String,String>> data) {
        loginPage.doRegister(data);
    }

}
