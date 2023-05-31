package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class RegistrationPage {

    /*********************************************GLOBAL_VARIABLES************************************************/
    private WebDriver driver;

    /*********************************************CONSTRUCTORS****************************************************/

//Needed because i will send the driver to be used as parameter w/ PageFactory so it can be used w/ @FindBy to locate elements

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

/*********************************************WEB_ELEMENTS********************************************************/

    @FindBy(id = "firstname")
    WebElement firstNameTxt;

    @FindBy(id = "lastname")
    WebElement lastNameTxt;

    @FindBy(id = "email_address")
    WebElement emailAddressTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "confirmation")
    WebElement passwordConfirmationTxt;

    @FindBy(css = "button[title='Register']")
    WebElement registerBtn;

    /*******************************************METHODS**********************************************************/

    public void clearInputs()
    {
        firstNameTxt.clear();
        lastNameTxt.clear();
        emailAddressTxt.clear();
        passwordTxt.clear();
        passwordConfirmationTxt.clear();
    }


    public void insertRegistrationInfo(String firstName, String lastName, String emailAddress, String password)
    {
        clearInputs();
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
        emailAddressTxt.sendKeys(emailAddress);
        passwordTxt.sendKeys(password);
        passwordConfirmationTxt.sendKeys(password);
    }

    public void submitRegistration()
    {
        registerBtn.click();
    }


    /*******************************************ASSERTIONS**********************************************************/

    public void successRegistrationMsg()
    {
        String expectedResult = "Thank you for registering with Madison Island.";
        String actualResult = driver.findElement(By.xpath("//span[contains(text(), 'Thank you for registering with Madison Island.')]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    public void failRegistrationMsg()
    {
        String expectedResult = "There is already an account with this email address";
        String actualResult = driver.findElement(By.xpath("//span[contains(text(), 'There is already an account with this email address. If you are sure that it is your email address, ')]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }





}
