package itemsTests;

import baseTestCase.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddedItemsTest extends TestUtil {
    private final static String BASE_ITEM_ID = "add-to-cart-sauce-labs-";

    @Test(dataProvider = "added items to cart")
    public void addItemsToCart(String items){
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

        WebElement addedItem = driver.findElement(By.id(BASE_ITEM_ID + items));
        addedItem.click();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));

        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }
    @DataProvider( name = "added items to cart")
    public Object[] getAddedItems(){
        return new Object[]{
                "bike-light",
                "bolt-t-shirt"


        };
    }
}

