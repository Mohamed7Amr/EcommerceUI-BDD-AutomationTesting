package tests.StepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Hooks {
    /********************************************ATTRIBUTES*************************************/
   public static WebDriver driver;

    /*********************************************METHODS****************************************************/
    @Before
    public void setUpEnvironment()
    {
        driver  = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        driver.get("http://magento-demo.lexiconn.com/");
        driver.manage().window().maximize();

        String expectedResult = "http://magento-demo.lexiconn.com/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @After
    public void cleanUpEnvironment() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
