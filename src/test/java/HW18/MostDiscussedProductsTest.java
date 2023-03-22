package HW18;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class MostDiscussedProductsTest extends Driver{
    @Test
    public void findMostDiscussedProducts(){
        driver.get("https://rozetka.com.ua/ua/");

        List<WebElement> products = new ArrayList<>();
        while (products.size() == 0) {
            List<WebElement> newProducts = driver.findElements(By.xpath("//h2[text() = ' Найбільш обговорювані товари ']/following-sibling::ul/li"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            products.addAll(newProducts);
            if (newProducts.size() != 0) break;
            }

        for (WebElement product : products) {
            String name = product.findElement(By.xpath(".//a[@class = 'tile__title']")).getAttribute("title");
            String price = product.findElement(By.xpath(".//div[contains(@class, 'tile__price ')]")).getText();
            System.out.println(name + " costs " + price + " uah");
        }
    }
}
