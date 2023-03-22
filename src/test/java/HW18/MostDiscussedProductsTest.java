package HW18;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class MostDiscussedProductsTest extends Driver{
    @Test
    public void findMostDiscussedProducts(){
        driver.get("https://rozetka.com.ua/ua/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,800)");

        WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Найчастіше додають в лист бажань')]"));
        jse.executeScript("arguments[0].scrollIntoView();", element);

        WebElement element2 = driver.findElement(By.xpath("(//h2[text() = ' Найбільш обговорювані товари ']" +
                "//following-sibling::ul/li//a[@class = 'tile__title'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView();", element2);

        List<WebElement> products = driver.findElements(By.xpath("//h2[text() = " +
                "' Найбільш обговорювані товари ']//following-sibling::ul/li"));
        for (WebElement product : products) {
            String name = product.findElement(By.xpath(".//a[@class = 'tile__title']")).getAttribute("title");
            String price = product.findElement(By.xpath(".//div[contains(@class, 'tile__price ')]")).getText();
            System.out.println(name + " costs " + price + " uah");
        }
    }
}
