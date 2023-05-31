package tests.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;


public class LoginStepDef {

//    WebDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(Hooks.driver);
    LoginPage lp = new LoginPage(Hooks.driver);

    @Given("user navigates to the login webpage")
    public void openBrowser()
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

//    @When("user enters valid username and invalid password")
//    public void insertInvalidCredentials()
//    {
//        lp.login("boogiemon@divalia.cf", "654321");
//    }

    @Then("user is not logged-in to his account")
    public void successMessage()
    {
        lp.failLoginMsg();
    }


}
