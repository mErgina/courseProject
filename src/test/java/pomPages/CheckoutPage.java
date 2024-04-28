package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage{


    @FindBy(id = "cart_contents_container")
    WebElement cartPage;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "continue-shopping")
     WebElement  continueShoppingBtn;


    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt(){

        return cartPage.isDisplayed();
    }


}
