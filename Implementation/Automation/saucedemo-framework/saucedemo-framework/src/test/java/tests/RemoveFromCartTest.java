package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveFromCartTest {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("--- Starting: Remove From Cart Test ---");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/" );
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        
        Thread.sleep(1000);
        
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        
        System.out.println("SUCCESS: Product was removed from the cart.");
        
        Thread.sleep(3000);
        driver.quit();
        System.out.println("--- Test Finished ---");
    }
}
