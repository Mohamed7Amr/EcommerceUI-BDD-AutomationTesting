package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ShoesSubcategoryPage;


public class UnitTests  {

    WebDriver driver = new ChromeDriver();
    ShoesSubcategoryPage ssp = new ShoesSubcategoryPage(driver);


    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver.get("http://magento-demo.lexiconn.com/accessories/shoes.html?dir=asc&order=price");
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void scrollEle()
    {
        ssp.scrollPageToDorianShoes();
    }

    @Test(enabled = false)
    public void getTitle()
    {
        System.out.println(driver.findElement(By.xpath("//h1[.='Shoes']")).getText());
    }

    @Test(enabled = true)
    public void getSelectAttributeOfPriceLi()
    {
       String selectAttributeValue = driver.findElement(By.xpath("//option[@value='http://magento-demo.lexiconn.com/accessories/shoes.html?dir=asc&order=price'][contains(.,'Price')]")).getAttribute("select");
        System.out.println(selectAttributeValue);
    }

}
