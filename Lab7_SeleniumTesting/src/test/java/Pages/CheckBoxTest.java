package Pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBoxTest {
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
    public void checkBoxCategory (){
        edge.get("https://practicesoftwaretesting.com/");
        edge.manage().window().setSize(new Dimension(1720, 934));
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")));
        edge.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")).click();
        boolean enabled=edge.findElement(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")).isEnabled();
        assertTrue(enabled);
    }
    @Test
    public void checkBoxBrand(){
        edge.get("https://practicesoftwaretesting.com/");
        edge.manage().window().setSize(new Dimension(1720, 934));
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"filters\"]/div[2]/ul/div[1]/label/input")));
        edge.findElement(By.xpath("//*[@id=\"filters\"]/div[6]/label/input")).click();
        boolean enabled=edge.findElement(By.xpath("//*[@id=\"filters\"]/div[6]/label/input")).isEnabled();
        assertTrue(enabled);
    }
}
