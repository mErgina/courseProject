package pomLoginTests;

import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomPages.LoginPage;
import pomPages.ProductPage;

public class SuccessfulLogin extends TestUtil {
    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productsPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isAt());
    }
}
