import Setara.Page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class LoginV1StepDef {
    AndroidDriver driver;
    LoginPage loginPage;

    public LoginV1StepDef(AndroidDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "C:/Users/Adhitya Andriansyah/Downloads/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 .apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUser(username);;
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user is on home page")
    public void userIsOnHomePage() {
        Assert.assertEquals(loginPage.getTextError(), "Masukkan user id anda");
        Assert.assertEquals(loginPage.getTextError2(), "Masukkan password anda");
    }
}
