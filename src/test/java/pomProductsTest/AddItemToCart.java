package pomProductsTest;

import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomPages.LoginPage;
import pomPages.ProductPage;

public class AddItemToCart extends TestUtil {
    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productsPage = loginPage.login("standard_user", "secret_sauce");


        productsPage.addItemToTheCart("bolt-t-shirt");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1);

        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 2);


    }
}
