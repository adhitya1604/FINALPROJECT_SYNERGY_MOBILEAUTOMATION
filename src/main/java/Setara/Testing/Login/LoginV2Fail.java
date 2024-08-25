package Setara.Testing.Login;


import Setara.Page.HomePage;
import Setara.Page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LoginV2Fail  {
    protected static AndroidDriver driver;

    @BeforeTest
    public void setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName" , "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "E:/Download/app-debug.apk");
        capabilities.setCapability("appPackage", "com.synrgyseveneight.bcarevamp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.synrgyseveneight.bcarevamp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }
    @Test
    public void LoginV2Fail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("ADTP604T");
        loginPage.inputPassword("andika12345");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getDashboardText(), "Halo, Andhika Putra!");


        homePage.clickLogoutButton();
        homePage.clickLogoutButtonvalid();
        loginPage.inputPassword("12345678");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getTextError2(), "Password yang dimasukkan salah");

    }

    @AfterTest
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}