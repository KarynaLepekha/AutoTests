package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CreateTestDriver {

    @Test
    public void rozetka() {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); another way than below
        WebDriverManager.chromedriver().arch64().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Acer Aspire");
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Знайти')]"));
        searchButton.click();
        WebElement thirdProduct1 = driver.findElement(By.xpath("(//span[@class = 'goods-tile__title'])[3]"));
        thirdProduct1.click();
        WebElement addToCart = driver.findElement(By.xpath("//button[contains(@class, 'button--green button--medium')]"));
        addToCart.click();
        WebElement closeCartModal = driver.findElement(By.xpath("//button[@aria-label = 'Закрити модальне вікно']"));
        closeCartModal.click();
        //search.sendKeys("FREGGIA", Keys.ENTER);
        WebElement searchOnPDP = driver.findElement(By.name("search"));
        searchOnPDP.sendKeys("FREGGIA", Keys.ENTER);
        WebElement thirdProduct2 = driver.findElement(By.xpath("(//span[@class = 'goods-tile__title'])[3]"));
        thirdProduct2.click();
        WebElement addToCart2 = driver.findElement(By.xpath("//button[contains(@class, 'button--green button--medium')]"));
        addToCart2.click();
        List<WebElement> productsInCart = driver.findElements(By.xpath("//ul[@class= 'cart-list']//li[@class= 'cart-list__item ng-star-inserted']"));
        Assert.assertEquals(productsInCart.toArray().length, 2);
        Assert.assertTrue(productsInCart.get(0).getText().contains("Acer Aspire"));
        Assert.assertTrue(productsInCart.get(1).getText().contains("FREGGIA"));
        //driver.quit();
    }
}
