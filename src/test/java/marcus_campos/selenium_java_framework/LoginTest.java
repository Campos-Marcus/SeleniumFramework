package marcus_campos.selenium_java_framework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import marcus_campos.selenium_java_framework.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    @Test
    void loginTest() {

        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertTrue(driver.getCurrentUrl().contains("inventory"));

        driver.quit();
    }
}
