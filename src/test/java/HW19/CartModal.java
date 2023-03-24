package HW19;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CartModal extends BasePage{
    @FindBy(xpath = "//button[@aria-label = 'Закрити модальне вікно']")
    private WebElement  closeCartModal;
    @FindBy(xpath = "//ul[@class= 'cart-list']//li[@class= 'cart-list__item ng-star-inserted']")
    private List<WebElement> productsInCart;

    public CartModal(WebDriver driver) {
        super(driver);
    }

    public void closeCartModal() {
        closeCartModal.click();
    }

    public List<WebElement> getProductsInCart() {
        return productsInCart;
    }
}
