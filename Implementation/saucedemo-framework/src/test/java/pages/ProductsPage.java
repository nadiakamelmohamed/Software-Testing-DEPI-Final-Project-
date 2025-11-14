package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    By productsList = By.cssSelector(".inventory_item");
    By sortDropdown = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductsCount() {
        return driver.findElements(productsList).size();
    }

    public void sortBy(String option) {
        driver.findElement(sortDropdown).sendKeys(option);
    }
}
