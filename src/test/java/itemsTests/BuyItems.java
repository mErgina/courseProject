package itemsTests;

import baseTestCase.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyItems extends TestUtil {
    private final static String BASE_ITEM_ID = "add-to-cart-sauce-labs-";

    @Test
    public void addProductToCartAndBuy(String item) {
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_ITEM_ID + item));
        itemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        shoppingCartBadge.click();

        WebElement yourCartPage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

        WebElement checkoutBtn = driver.findElement(By.id(".checkout"));
        checkoutBtn.click();

        Assert.assertTrue(yourCartPage.isDisplayed());


    }

    @DataProvider(name = "added items to cart")
    public Object[] getAddedItems() {
        return new Object[]{
                "bike-light",
                "bolt-t-shirt"


        };
    }
}
