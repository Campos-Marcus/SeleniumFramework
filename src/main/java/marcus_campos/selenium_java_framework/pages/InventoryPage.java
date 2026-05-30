package marcus_campos.selenium_java_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inventoryTitle = By.className("title");

    private By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");

    private By cartBadge = By.className("shopping_cart_badge");

    public boolean isPageLoaded() {

        return driver.findElement(inventoryTitle)
                .isDisplayed();
    }

    public void addBackpackToCart() {

        driver.findElement(backpackAddButton)
                .click();
    }

    public String getCartBadgeValue() {

    return driver.findElement(cartBadge)
            .getText();
}
}