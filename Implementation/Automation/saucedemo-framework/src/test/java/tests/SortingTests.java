package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.Test;

public class SortingTests extends BaseTest {

    @Test
    public void sortProductsTest() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        ProductsPage products = new ProductsPage(driver);
        products.sortBy("Price (low to high)");
    }
}
