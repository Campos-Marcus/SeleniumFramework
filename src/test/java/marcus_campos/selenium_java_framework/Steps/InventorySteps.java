package marcus_campos.selenium_java_framework.Steps;

import marcus_campos.selenium_java_framework.pages.InventoryPage;
import org.openqa.selenium.WebDriver;

public class InventorySteps {

    private InventoryPage inventoryPage;

    public InventorySteps(WebDriver driver) {
        inventoryPage = new InventoryPage(driver);
    }

    public void addBackpackToCart() {

        inventoryPage.addBackpackToCart();

    }

    public String getCartBadgeValue() {
        return inventoryPage.getCartBadgeValue();
    }
}