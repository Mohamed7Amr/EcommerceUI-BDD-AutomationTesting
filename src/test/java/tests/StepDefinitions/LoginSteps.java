package tests.StepDefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;


public class LoginSteps {

    HomePage hp = new HomePage(Hooks.driver);
    LoginPage lp = new LoginPage(Hooks.driver);

    @Given("user navigates to the login webpage")
    public void openLoginWebpage()
    {
        hp.clickAccountBtn();
        hp.clickLoginLi();
    }

    @When("^user enters \"(.*)\" and \"(.*)\"$")
    public void insertCredentials(String username, String password)
    {
        lp.login(username, password);
    }

    @Then("user is logged-in to his account")
    public void successfulLogin()
    {
        lp.successLoginMsg();
    }

    @Then("user is not logged-in to his account")
    public void successMessage()
    {
        lp.failLoginMsg();
    }


}
