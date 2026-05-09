package marcus_campos.selenium_java_framework;

import marcus_campos.selenium_java_framework.base.BaseTest;
import marcus_campos.selenium_java_framework.pages.LoginPage;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("inventory"));
    }
}