package HW19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'button--green button--medium')]")
    private WebElement addToCart;
    @FindBy(xpath = "//rz-cart")
    private WebElement cart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartModal addToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
        return new CartModal(driver);
    }
    public void openCart() {
        cart.click();
    }

}
