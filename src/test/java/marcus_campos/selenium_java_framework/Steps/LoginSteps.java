package marcus_campos.selenium_java_framework.Steps;

import marcus_campos.selenium_java_framework.models.User;
import marcus_campos.selenium_java_framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void openLoginPage() {
        loginPage.reachPage();
    }

    public void login(User user) {
        loginPage.login(user);
    }
}