package Pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SortingTest {
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
    public void testSorting() {
        edge.get("https://practicesoftwaretesting.com/");
        edge.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (A - Z)']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Name (Z - A)']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (High - Low)']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"sort\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"sort\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Price (Low - High)']")).click();
        }
    }
}
