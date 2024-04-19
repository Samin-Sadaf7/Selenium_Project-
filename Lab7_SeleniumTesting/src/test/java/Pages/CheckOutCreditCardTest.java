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

public class CheckOutCreditCardTest {
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
    public void testCheckOutCreditCard(){
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        edge.manage().window().setSize(new Dimension(649, 2000));
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome02");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        edge.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        edge.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-home\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"nav-home\"]")).click();
        edge.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")));
        edge.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[1]/div[1]/img")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"increase-quantity\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler")));
        edge.findElement(By.cssSelector(".navbar-toggler")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".navbar-toggler-icon")));
        edge.findElement(By.cssSelector(".navbar-toggler-icon")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")));
        edge.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a/i")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-1\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"proceed-1\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-2\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"proceed-2\"]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("*[data-test=\"address\"]"), "Test street 98"));
        edge.findElement(By.cssSelector("*[data-test=\"state\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"state\"]")).sendKeys("Dhaka");
        edge.findElement(By.cssSelector("*[data-test=\"postcode\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"postcode\"]")).sendKeys("1001");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"proceed-3\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"proceed-3\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"payment-method\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"payment-method\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Credit Card']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).click();
        edge.findElement(By.id("credit_card_number_help")).click();
        edge.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"credit_card_number\"]")).sendKeys("0000-0000-0000-0000");
        edge.findElement(By.cssSelector("*[data-test=\"expiration_date\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"expiration_date\"]")).sendKeys("10/2025");
        edge.findElement(By.cssSelector("*[data-test=\"cvv\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"cvv\"]")).sendKeys("1233");
        edge.findElement(By.cssSelector("*[data-test=\"card_holder_name\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"card_holder_name\"]")).sendKeys("samin");
        edge.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
    }
}
