package HW19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[contains(@class, 'button--green button--medium')]")
    private WebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartModal addToCart() {
        addToCart.click();
        return new CartModal(driver);
    }
}
