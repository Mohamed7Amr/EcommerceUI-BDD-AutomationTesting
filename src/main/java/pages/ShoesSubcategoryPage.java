package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoesSubcategoryPage {

    /*********************************************GLOBAL_VARIABLES************************************************/
    public WebDriver driver;


    /*********************************************CONSTRUCTORS****************************************************/

    public ShoesSubcategoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    /*********************************************WEB_ELEMENTS********************************************************/

    @FindBy(xpath = "//select[@title='Sort By']")
    WebElement sortDDL;

    @FindBy(xpath = "//option[@value='http://magento-demo.lexiconn.com/accessories/shoes.html?dir=asc&order=position'][contains(.,'Position')]")
    WebElement positionOption;

    @FindBy(xpath = "//option[@value='http://magento-demo.lexiconn.com/accessories/shoes.html?dir=asc&order=name'][contains(.,'Name')]")
    WebElement nameOption;

    @FindBy(xpath = "//option[@value='http://magento-demo.lexiconn.com/accessories/shoes.html?dir=asc&order=price'][contains(.,'Price')]")
    WebElement priceOption;

    @FindBy(xpath="//a[@href='http://magento-demo.lexiconn.com/accessories/shoes/dorian-preforated-oxford-558.html'][@class='button']")
    WebElement viewDetailsDorianBtn;

    @FindBy(xpath = "//span[@class='regular-price']/span[@class='price']")
    List<WebElement>shoesPrices;


    /*******************************************METHODS**********************************************************/

    public void selectSortOption(int index) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Select optionsList = new Select(sortDDL);

        int optionsNumber = optionsList.getOptions().size();
        if(optionsNumber!=3)
        {
            System.out.println(optionsNumber);
            Assert.assertEquals(3,optionsNumber,"Shoes sorting options are not 3");
        }

        optionsList.selectByIndex(index);

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        String selectAttribute;
        switch (index)
        {
            /*Was not possible to use Selenium-java becauseThe select attribute may have been added dynamically by JavaScript after the DOM
             was initially loaded. getAttribute() only checks the original HTML, it does not check for dynamically added attributes.
             */
//            case 0: Assert.assertTrue(positionOption.getAttribute("selected")=="selected","position option isn't selected");break;
//            case 1: Assert.assertTrue(nameOption.getAttribute("selected")=="selected","name option isn't selected");break;
//            case 2: Assert.assertTrue(priceOption.getAttribute("selected").equals("selected"),"price option isn't selected");break;

            case 0: selectAttribute = (String) js.executeScript("return arguments[0].getAttribute('selected');",positionOption);
                Assert.assertEquals(selectAttribute,"selected","price option using js is not found");break;

            case 1: selectAttribute = (String) js.executeScript("return arguments[0].getAttribute('selected');",nameOption);
                Assert.assertEquals(selectAttribute,"selected","price option using js is not found");break;

            case 2: selectAttribute = (String) js.executeScript("return arguments[0].getAttribute('selected');",priceOption);
                    Assert.assertEquals(selectAttribute,"selected","price option using js is not found");break;
            default:System.out.println("Something is defo wrong lol");break;
        }

    }

    public void clickViewDetailsDorianBtn()
    {
        viewDetailsDorianBtn.click();
    }


    public void confirmShoesAscendingPrice()
    {
        int elementsSize = shoesPrices.size();

        /**
         * Notice that i already know from the DOM that it's only 3 elements,thus max index is 2, but if i has become 2,
         * what is i+1?->3,IndexOutOfBoundsError!. thus had to make condition i < elementsSize-1
         */
        for(int i =0; i<elementsSize-1; i++)
        {
            String currentShoesPriceString = shoesPrices.get(i).getText().replace("$","");
            String nextShoesPriceString = shoesPrices.get(i+1).getText().replace("$","");

            double currentShoesPriceNum = Double.parseDouble(currentShoesPriceString);
            double nextShoesPriceNum = Double.parseDouble(nextShoesPriceString);
            Assert.assertTrue(nextShoesPriceNum>currentShoesPriceNum,"prices are not re-arranged in ascending matter");
        }
    }

    public void scrollPageToDorianShoes()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",viewDetailsDorianBtn);
    }

}
