package tests.StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.DorianShoesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoesSubcategoryPage;

import java.util.concurrent.TimeUnit;

public class AddCartSteps {

    HomePage hp = new HomePage(Hooks.driver);
    LoginPage lp = new LoginPage(Hooks.driver);
    ShoesSubcategoryPage ssp = new ShoesSubcategoryPage(Hooks.driver);
    DorianShoesPage dsp = new DorianShoesPage(Hooks.driver);


    @Given("User logs-in to his account")
    public void userLogin()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        hp.clickAccountBtn();
        hp.clickLoginLi();
        lp.login("baeanchik@correoparacarlos.ml", "123456");
    }

    @When("hovers on the Accessories category")
    public void accessoriesDDL() throws InterruptedException {
        hp.hoverOnAccessoriesCateg();
        Thread.sleep(2000);
    }

    @And("chooses shoes subcategory")
    public void selectShoesSubcategory()
    {
        hp.clicksShoesSubcategory();
    }

    @Then("redirected to the shoes subcategory showing Shoes header")
    public void shoesWebpageInterface()
    {
        String expectedResult1 = "http://magento-demo.lexiconn.com/accessories/shoes.html";
        String actualResult1 = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualResult1,expectedResult1,"Shoes webpage is not found");

        String expectedResult2 = "SHOES";
        String actualResult2 = Hooks.driver.findElement(By.xpath("//h1[.='Shoes']")).getText();
        Assert.assertTrue(actualResult2.contains(expectedResult2),"Shoes title is not found in the webpage thus wrong page");

    }

    @When("filters all pairs of shoes by Price from low to high")
    public void sortShoesByPrice() throws InterruptedException {
        ssp.selectSortOption(2);
        Thread.sleep(2000);
    }

    @Then("all pairs of shoes will be sorted by price")
    public void shoesResortedByPrice() {

        ssp.confirmShoesAscendingPrice();
    }

    @When("views details of the chosen shoes product")
    public void showProductDetails() throws InterruptedException {
        ssp.scrollPageToDorianShoes();
        Thread.sleep(1500);
        ssp.clickViewDetailsDorianBtn();
    }

    @Then ("redirected to Dorian shoes details")
    public void redirectsToDorianShoes()
    {
        String expectedResult = "DORIAN PERFORATED OXFORD";
        String actualResult = dsp.getShoesTitle();

        Assert.assertTrue(actualResult.contains(expectedResult),"Details of the chosen Dorian shoes is not displayed");
    }

    @When("selects color of the shoes product")
    public void selectShoesColor() throws InterruptedException {
        dsp.selectColorOption("Black");
        Thread.sleep(1500);
    }

    @And("chooses size of the shoes product")
    public void selectShoesSize() throws InterruptedException {
        dsp.selectSizeOption("97");
        Thread.sleep(1500);
    }

    @And("adds to cart")
    public void addShoesToCart()
    {
        dsp.clickAddToCart();
    }

    @Then("redirected to the checkout-cart")
    public void redirectToShoppingCart()
    {
        String expectedResult = "http://magento-demo.lexiconn.com/checkout/cart/";
        String actualResult = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult);
    }

}
