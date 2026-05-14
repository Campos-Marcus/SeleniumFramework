package marcus_campos.selenium_java_framework;

import marcus_campos.selenium_java_framework.Steps.LoginSteps;
import marcus_campos.selenium_java_framework.base.BaseTest;
import marcus_campos.selenium_java_framework.models.User;
import marcus_campos.selenium_java_framework.pages.LoginPage;
import marcus_campos.selenium_java_framework.utils.CsvReader;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    static Stream<User> userProvider() {
        return CsvReader.readUsersFromCsv().stream();
    }

    @ParameterizedTest
    @MethodSource("userProvider")
    void loginTest(User user) {

        LoginSteps steps = new LoginSteps(driver);

        steps.openLoginPage();
        steps.login(user);

        if (user.shouldLoginSucceed()) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains("inventory"));
        } else {
            // later: assert error message
        }
    }

}