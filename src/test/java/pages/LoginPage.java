package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage {
    private static final Logger Log = LogManager.getLogger(LoginPage.class);

    String baseURL = "https://www.saucedemo.com";
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By loginErrorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        Log.info("Opening website " + baseURL);
        driver.get(baseURL);
        return this;
    }

    public LoginPage login(String username, String password) {
        Log.info("Trying to login.");
        writeText(usernameInput, username);
        writeText(passwordInput, password);
        click(loginButton);
        return this;
    }

    public LoginPage verifyLoginUsernameAndPassword(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(loginErrorMessage);
        assertEquals(readText(loginErrorMessage), expectedText);
        return this;
    }
}
