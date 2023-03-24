package HW19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(name = "search")
    private WebElement search;
    @FindBy(xpath = "//button[contains(text(), 'Знайти')]")
    private WebElement searchButton;

    public void productSearch(String product) {
        search.sendKeys(product);
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
