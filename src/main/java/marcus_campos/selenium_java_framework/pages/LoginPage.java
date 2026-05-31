package marcus_campos.selenium_java_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import marcus_campos.selenium_java_framework.models.User;

public class LoginPage {

    private WebDriver driver;
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage login(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLogin();

        return new InventoryPage(driver);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void reachPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public boolean hasLoginError() {
        return driver.findElement(errorMessage)
                .isDisplayed();
    }

}