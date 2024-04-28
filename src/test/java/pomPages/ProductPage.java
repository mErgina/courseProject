package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    private final static String PRODUCT_BASE_ID = "add-to-cart-sauce-labs-";


    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsPageTitle;

    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;



    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean isAt(){
        return productsPageTitle.isDisplayed();

    }

    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_BASE_ID + itemName));
        itemToBeAdded.click();
    }


    public int getItemsInTheCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }


}

