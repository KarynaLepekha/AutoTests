package HW19;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsToBasketTest extends BaseTest{
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private CartModal cartModal;

    @Test
    public void rozetka() {

        mainPage = openRozetka();
        for (String product : Data.getProducts()) {
            mainPage.productSearch(product);
            searchResultsPage = mainPage.clickSearchButton();
            productPage = searchResultsPage.thirdProductOnThePage();
            cartModal = productPage.addToCart();
            sleepALittleBit(2);
            cartModal.closeCartModal();
        }
        //Verify the amount of products in the cart is correct
        sleepALittleBit(2);
        productPage.openCart();
        Assert.assertEquals(cartModal.getProductsInCart().toArray().length, Data.getProducts().length);

    }
}
