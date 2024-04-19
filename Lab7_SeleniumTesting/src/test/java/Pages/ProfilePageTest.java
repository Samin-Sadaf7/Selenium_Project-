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

public class ProfilePageTest {
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
    public void testProfilePage(){
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        edge.manage().window().setSize(new Dimension(649, 789));
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome02");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-profile\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"nav-profile\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"phone\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"phone\"]")).sendKeys("1234");
        edge.findElement(By.cssSelector("*[data-test=\"update-profile-submit\"]")).click();
    }
}
