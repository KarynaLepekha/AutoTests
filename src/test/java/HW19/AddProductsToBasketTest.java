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
        //search first product and add it to the cart
        mainPage.productSearch();
        searchResultsPage = mainPage.clickSearchButton();
        productPage = searchResultsPage.thirdProductOnThePage();
        cartModal = productPage.addToCart();
        sleepALittleBit(2);
        cartModal.closeCartModal();
        //search second product and add it to the cart
        mainPage.productSearch();
        mainPage.clickSearchButton();
        productPage = searchResultsPage.thirdProductOnThePage();
        cartModal = productPage.addToCart();
        sleepALittleBit(2);
        cartModal.closeCartModal();
        //search third product and add it to the cart
        mainPage.productSearch();
        mainPage.clickSearchButton();
        searchResultsPage.thirdProductOnThePage();
        productPage.addToCart();
        //Verify the amount of products in the cart is correct
        Assert.assertEquals(cartModal.getProductsInCart().toArray().length, 3);

    }
}
