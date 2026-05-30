package marcus_campos.selenium_java_framework;

import marcus_campos.selenium_java_framework.Steps.LoginSteps;
import marcus_campos.selenium_java_framework.base.BaseTest;
import marcus_campos.selenium_java_framework.models.User;
import marcus_campos.selenium_java_framework.pages.InventoryPage;
import marcus_campos.selenium_java_framework.utils.CsvReader;

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

        LoginSteps loginSteps = new LoginSteps(driver);

        loginSteps.openLoginPage();

        if (user.shouldLoginSucceed()) {

            InventoryPage inventoryPage = loginSteps.login(user);

            assertTrue(inventoryPage.isPageLoaded());

        } else {

            loginSteps.login(user);

            assertTrue(loginSteps.hasLoginError());
        }

    }

}