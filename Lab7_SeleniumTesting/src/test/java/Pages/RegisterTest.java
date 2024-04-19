package Pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class RegisterTest {
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
    public void testRegister() {
        edge.get("https://practicesoftwaretesting.com/#/auth/register");
        edge.manage().window().setSize(new Dimension(1936, 1056));
        edge.findElement(By.cssSelector("*[data-test=\"first-name\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"first-name\"]")).sendKeys("Samin");
        edge.findElement(By.cssSelector("*[data-test=\"last-name\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"last-name\"]")).sendKeys("Sadaf");
        edge.findElement(By.cssSelector("*[data-test=\"dob\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"dob\"]")).sendKeys("5"+"\t"+"10"+"\t"+"2002");
        edge.findElement(By.cssSelector("*[data-test=\"address\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"address\"]")).sendKeys("Dhaka");
        edge.findElement(By.cssSelector("*[data-test=\"postcode\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"postcode\"]")).sendKeys("1001");
        edge.findElement(By.cssSelector("*[data-test=\"city\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"city\"]")).sendKeys("Dhaka");
        edge.findElement(By.cssSelector("*[data-test=\"state\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"state\"]")).sendKeys("Dhaka");
        edge.findElement(By.cssSelector("*[data-test=\"country\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"country\"]"));
            dropdown.findElement(By.xpath("//option[. = 'Bangladesh']")).click();
        }
        edge.findElement(By.cssSelector(".form-group:nth-child(9)")).click();
        edge.findElement(By.cssSelector(".form-group:nth-child(9)")).click();
        {
            WebElement element = edge.findElement(By.cssSelector(".form-group:nth-child(9)"));
            Actions builder = new Actions(edge);
            builder.doubleClick(element).perform();
        }
        edge.findElement(By.cssSelector("*[data-test=\"phone\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"phone\"]")).sendKeys("123421341241");
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("practice@gmail.com");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("12345314142ASDFWDW!@@Fa");
        edge.findElement(By.cssSelector("*[data-test=\"register-submit\"]")).click();
    }
}
