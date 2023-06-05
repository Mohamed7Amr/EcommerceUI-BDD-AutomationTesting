package tests.StepDefinitions;


import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegistrationPage;


public class RegistrationSteps {

    HomePage hp = new HomePage(Hooks.driver);
    RegistrationPage rp = new RegistrationPage(Hooks.driver);//TestBase.DRIVER


    @Given("user navigates to the register webpage")
    public void navigateToRegistration()
    {
        hp.clickAccountBtn();
        hp.clickRegisterLi();
    }

    @When("user inserts needed info")
    public void insertUserInfo()
    {
        rp.clearInputs();
        rp.insertRegistrationInfo("Ahmed","Tarek","kanoce4011@ratedane.com","123456");
    }

    @And("submit")
    public void clickEnter()
    {
        rp.submitRegistration();
    }

    @Then("he receives a success message of registration")
    public void registerSuccessfully()
    {
        rp.successRegistrationMsg();
    }

    @Then("he receives a message says that this user has already been registered")
    public void userRegisteredBefore()
    {
        rp.failRegistrationMsg();
    }


}
