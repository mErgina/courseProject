package pomProductsTest;

import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomPages.CheckoutPage;
import pomPages.LoginPage;
import pomPages.ProductPage;

public class OrderAnItem extends TestUtil {
    @Test
    public void addItemandbuy() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productsPage = loginPage.login("standard_user", "secret_sauce");







    }
}
