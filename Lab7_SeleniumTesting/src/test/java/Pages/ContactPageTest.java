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

public class ContactPageTest {
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
    public void testContactPage() {
        edge.get("https://practicesoftwaretesting.com/");
        edge.manage().window().setSize(new Dimension(1936, 1056));
        edge.findElement(By.cssSelector("*[data-test=\"nav-contact\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("Samin");
        edge.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("Sadaf");
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("saminsadaf@gmail.com");
        edge.findElement(By.cssSelector("*[data-test=\"subject\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"subject\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Webmaster']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"message\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"message\"]")).sendKeys(
                "It's been a long day,\n" +
                        "It's been a long day,\n"+
                        "It's been a long day,\n"+
                        "It's been a long day,\n");
        edge.findElement(By.cssSelector(".row:nth-child(2)")).click();
        edge.findElement(By.cssSelector("*[data-test=\"contact-submit\"]")).click();

        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div"), "Thanks for your message! We will contact you shortly."));

        String message = edge.findElement(By.xpath("/html/body/app-root/div/app-contact/div/div/div/div")).getText();

        assertEquals("Thanks for your message! We will contact you shortly.", message);
    }
}
