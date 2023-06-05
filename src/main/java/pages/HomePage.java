package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

/*Some notations regarding variables naming:
1) variables' suffix "Li" means it's an ordered-list-item element.
2) variables' suffix "Categ" means it's a category element.
 */
    @FindBy(xpath = "//span[contains(text(),'Account')][@class = 'label']")
    WebElement AccountBtn;

    @FindBy(xpath = "//a[@href = 'http://magento-demo.lexiconn.com/customer/account/create/']")
    WebElement registerLi;

    @FindBy(xpath = "//a[@href = 'http://magento-demo.lexiconn.com/customer/account/login/']")
    WebElement loginLi;

    @FindBy(xpath = "//a[@class='level0 has-children'][contains(text(),'Accessories')]")
    WebElement accessoriesCateg;

    public WebElement accessoriesCategoryEle()
    {
        return driver.findElement(By.xpath("//a[@class='level0 has-children'][contains(text(),'Accessories')]"));
    }

    @FindBy (xpath = "//a[@class='level1 '][contains(text(),'Shoes')]")
    WebElement shoesLi;

    @FindBy (xpath = "//a[@class='level0 has-children'][contains(text(),'Home & Decor')]")
    WebElement home_decorCateg;

    @FindBy (xpath = "//a[@class='level1 '][contains(text(),'Books & Music')]")
    WebElement books_musicLi;


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

    public void clickAccessoriesCategory()
    {
        accessoriesCateg.click();
    }

    public void hoverOnAccessoriesCateg()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(accessoriesCateg).perform();
    }

    public void clicksShoesSubcategory()
    {
        shoesLi.click();
    }
}
