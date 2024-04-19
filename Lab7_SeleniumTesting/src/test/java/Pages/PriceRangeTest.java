package Pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class PriceRangeTest {
    public static WebDriver edge;
    public static JavascriptExecutor js;
    @BeforeAll
    public static void setUp() {
        //set path of edgeDriver.exe path
        js = (JavascriptExecutor) edge;
        System.setProperty("webdriver.edge.driver",
                "D:\\Software Testing and Quality Assurance\\msedgedriver.exe");
        //Set up options for EdgeDriver
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Set up EdgeDriver instance
        edge = new EdgeDriver(options);
    }
    @AfterAll
    public static void TestEnd() {
        edge.quit();
    }
    @Test
    public void testPriceRange(){
        edge.get("https://practicesoftwaretesting.com/");
        edge.manage().window().setSize(new Dimension(1936, 1056));
        edge.findElement(By.cssSelector(".ngx-slider-full-bar > .ngx-slider-span")).click();
        {
            WebElement element = edge.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(edge);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = edge.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(edge);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = edge.findElement(By.cssSelector(".ngx-slider-pointer-max"));
            Actions builder = new Actions(edge);
            builder.moveToElement(element).release().perform();
        }
        edge.findElement(By.cssSelector(".ngx-slider-pointer-max")).click();
        edge.findElement(By.cssSelector(".ngx-slider-selection-bar")).click();
    }

}
