package HW19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "(//span[@class ='goods-tile__title'])[3]")
    private WebElement thirdProductOnThePage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage thirdProductOnThePage() {
        thirdProductOnThePage.click();
        return new ProductPage(driver);
    }

}
