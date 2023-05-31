package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {

/*********************************************GLOBAL_VARIABLES************************************************/
private WebDriver driver;

/*********************************************CONSTRUCTORS****************************************************/

//Needed because i will send the driver to be used as parameter w/ PageFactory so it can be used w/ @FindBy to locate elements

    public  HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

/*********************************************SETTERS_&_GETTERS**************************************************/




/*********************************************WEB_ELEMENTS********************************************************/

    @FindBy(xpath = "//span[contains(text(),'Account')][@class = 'label']")
    WebElement AccountBtn;

    @FindBy(xpath = "//a[@href = 'http://magento-demo.lexiconn.com/customer/account/create/']")
    WebElement registerLi;

    @FindBy(xpath = "//a[@href = 'http://magento-demo.lexiconn.com/customer/account/login/']")
    WebElement loginLi;


    /*******************************************METHODS**********************************************************/

    public void clickAccountBtn()
    {
        AccountBtn.click();
    }

    public void clickRegisterLi()
    {
        registerLi.click();
    }

    public void clickLoginLi()
    {
        loginLi.click();
    }

}
