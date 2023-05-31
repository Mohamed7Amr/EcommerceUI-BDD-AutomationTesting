package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {

    /*********************************************GLOBAL_VARIABLES************************************************/
    private WebDriver driver;

    /*********************************************CONSTRUCTORS****************************************************/

//Needed because i will send the driver to be used as parameter w/ PageFactory so it can be used w/ @FindBy to locate elements

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


/*********************************************WEB_ELEMENTS********************************************************/

    @FindBy (id = "email")
    WebElement emailTxt;

    @FindBy (id = "pass")
    WebElement passwordTxt;

    @FindBy(id = "send2")
    WebElement loginBtn;

    /*******************************************METHODS**********************************************************/

    public void login(String email, String password)
    {
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }

    /*******************************************ASSERTIONS**********************************************************/

    public void successLoginMsg()
    {
        String expectedResult = "http://magento-demo.lexiconn.com/customer/account/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    public void failLoginMsg()
    {
        String expectedResult = "Invalid login or password.";
        String actualResult = driver.findElement(By.xpath("//span[contains(text(), 'Invalid login or password.')]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }






}
