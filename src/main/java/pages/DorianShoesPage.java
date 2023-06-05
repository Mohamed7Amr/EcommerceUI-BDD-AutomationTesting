package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DorianShoesPage {

    /*********************************************GLOBAL_VARIABLES************************************************/

    WebDriver driver;

    /*********************************************CONSTRUCTORS****************************************************/

    public DorianShoesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*********************************************WEB_ELEMENTS********************************************************/

    @FindBy(xpath = "//span[@class='h1'][contains(.,'Oxford')]")
    WebElement shoesTitle;

    @FindBy(id = "attribute92")
    WebElement colorOptionsDDL;

    @FindBy(id = "attribute186")
    WebElement sizeOptionsDDL;

    @FindBy(xpath = "//button[not(contains(@id,'map-popup-button'))][@class='button btn-cart']")
    WebElement addToCartBtn;

    /*******************************************METHODS**********************************************************/

    public String getShoesTitle()
    {
        return shoesTitle.getText();
    }

    public void selectColorOption(String text)
    {
        Select colorOptionsList =  new Select(colorOptionsDDL);
        colorOptionsList.selectByVisibleText(text);
    }

    public void selectSizeOption(String value)
    {
        //Did not do switch becuz there are no assertions that can be done as there's nth changes in the DOM when i select an Option.
        Select sizeShoesList = new Select(sizeOptionsDDL);
        sizeShoesList.selectByValue(value);
    }

    public void clickAddToCart()
    {
        addToCartBtn.click();
    }
}
