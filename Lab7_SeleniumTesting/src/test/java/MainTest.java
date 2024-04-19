

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest{
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
    public void testURLaunch(){
        edge.get("https://bing.com/");
    }
    @Test
    public void testSignup() {
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")));
        edge.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.id("password")).sendKeys("welcome02");
        edge.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
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
    @Test
    public void testForgotPassword(){
        edge.get("https://practicesoftwaretesting.com/#/auth/forgot-password");
        edge.manage().window().setSize(new Dimension(1936, 1056));
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("saminsadaf@gmail.com");
        edge.findElement(By.cssSelector("*[data-test=\"forgot-password-submit\"]")).click();
    }
    @Test
    public void testCheckOutBuyNowPayLater(){
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        edge.manage().window().setSize(new Dimension(649, 2000));
        WebDriverWait first_wait = new WebDriverWait(edge, Duration.ofSeconds(3));
        first_wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")));
        edge.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.id("password")).sendKeys("welcome02");
        edge.findElement(By.xpath("/html/body/app-root/div/app-login/div/div/div/form/div[3]/input")).click();
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(20));
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
            dropdown.findElement(By.xpath("//option[. = 'Buy Now Pay Later']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"monthly_installments\"]")).click();
        {
            WebElement dropdown = edge.findElement(By.cssSelector("*[data-test=\"monthly_installments\"]"));
            dropdown.findElement(By.xpath("//option[. = '3 monthly installments']")).click();
        }
        edge.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
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
    @Test
    public void productDetails(){
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        edge.manage().window().setSize(new Dimension(649, 789));
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome02");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(5));
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
        edge.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"increase-quantity\"]")).click();
        edge.findElement(By.cssSelector(".fa-minus")).click();
        edge.findElement(By.cssSelector(".fa-minus")).click();
        edge.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"add-to-favorites\"]")).click();
    }
    @Test
    public void testFavouritePage(){
        edge.get("https://practicesoftwaretesting.com/#/auth/login");
        edge.manage().window().setSize(new Dimension(649, 789));
        WebDriverWait wait = new WebDriverWait(edge, Duration.ofSeconds(5));
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"email\"]")).sendKeys("customer@practicesoftwaretesting.com");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("welcome02");
        edge.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys(Keys.ENTER);
        WebDriverWait wait1 = new WebDriverWait(edge, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-test=\"nav-favorites\"]")));
        edge.findElement(By.cssSelector("*[data-test=\"nav-favorites\"]")).click();
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