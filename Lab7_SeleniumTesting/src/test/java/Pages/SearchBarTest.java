package Pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchBarTest {
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
    public void searchBar(){
        edge.get("https://practicesoftwaretesting.com/");
        edge.manage().window().setSize(new Dimension(1936, 1056));
        edge.findElement(By.cssSelector("*[data-test=\"search-query\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys("Thor Hammer");
        edge.findElement(By.cssSelector("*[data-test=\"search-query\"]")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test=\"search_completed\"]")));

        String result=edge.findElement(By.cssSelector("[data-test=\"search_completed\"]")).getText();
        assertEquals("Thor Hammer\n" +
                "$11.14", result);
    }
}
