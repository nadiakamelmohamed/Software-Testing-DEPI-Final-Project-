package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin() {
        test = extent.createTest("Valid Login");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void invalidLogin() {
        test = extent.createTest("Invalid Login");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("invalid_user");
        login.enterPassword("wrong_pass");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"));
    }

    @Test
    public void lockedUserLogin() {
        test = extent.createTest("Locked User Login");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("locked_out_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("locked out"));
    }
}
