package HW19;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductsToCartTest extends BaseTest{
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private CartModal cartModal;

    @Test //test will run 2 times - invocationCount = 2
    public void rozetka() {

        mainPage = openRozetka();
        for (String product : Data.getProducts()) {
            mainPage.productSearch(product);
            searchResultsPage = mainPage.clickSearchButton();
            productPage = searchResultsPage.thirdProductOnThePage();
            cartModal = productPage.addToCart();
            cartModal.closeCartModal();
        }
        //Verify the amount of products in the cart is correct
        productPage.openCart();
        Assert.assertEquals(cartModal.getProductsInCart().toArray().length, Data.getProducts().length);
    }
}
