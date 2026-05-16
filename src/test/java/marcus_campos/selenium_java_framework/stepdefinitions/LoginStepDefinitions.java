package marcus_campos.selenium_java_framework.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import marcus_campos.selenium_java_framework.Steps.LoginSteps;
import marcus_campos.selenium_java_framework.models.User;
import marcus_campos.selenium_java_framework.utils.DriverFactory;

public class LoginStepDefinitions {
    @Before
    public void setup() {

        driver = DriverFactory.createDriver();

        loginSteps = new LoginSteps(driver);
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver driver;
    private LoginSteps loginSteps;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginSteps.openLoginPage();
    }

    @When("the user logs in with username {string} and password {string}")
    public void userLogsIn(String username, String password) {
        User user = new User(username, password, true);

        loginSteps.login(user);

    }

    @Then("the inventory page should be displayed")
    public void inventoryPageShouldBeDisplayed() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("inventory"));
    }

}
