package HW19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'button--green button--medium')]")
    private WebElement addToCart;
    @FindBy(xpath = "//button[@class = 'header__button ng-star-inserted header__button--active']")
    private WebElement cart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartModal addToCart() {
        addToCart.click();
        return new CartModal(driver);
    }
    public void openCart() {
        cart.click();
    }

}
