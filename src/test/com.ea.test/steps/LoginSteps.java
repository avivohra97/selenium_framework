package com.ea.test.steps;

import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import com.ea.test.seleniumtest.TestInitialize;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;


public class LoginSteps extends TestInitialize {

    @Before
    @Override
    public void initialize() throws IOException {
        super.initialize();
    }


    @And("I see application opened")
    public void iSeeApplicationOpened() {
        currentPage = currentPage.GetInstance(HomePage.class);
        Assert.assertTrue("the login page is not loaded",currentPage.As(HomePage.class).IsLogin());
    }

    @Then("I click login link")
    public void iClickLoginLink() {
        currentPage.As(HomePage.class).clickLogin();
    }

    @When("I enter UserName and Password")
    public void iEnterUserNameAndPassword(DataTable data) {
        List<List<String>> table = data.asLists();
        currentPage.As(LoginPage.class).Login(table.get(1).get(0).toString(),table.get(1).get(1).toString());
    }

    @Then("I click login button")
    public void iClickLoginButton() {
        
    }

    @Then("I should see the username with hello")
    public void iShouldSeeTheUsernameWithHello() {
    }
}
