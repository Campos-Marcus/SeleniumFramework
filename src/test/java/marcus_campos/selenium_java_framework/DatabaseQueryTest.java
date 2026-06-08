package marcus_campos.selenium_java_framework;

import marcus_campos.selenium_java_framework.database.Customer;
import marcus_campos.selenium_java_framework.database.CustomerQueries;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseQueryTest {

    @Test
    void shouldFindCustomerById()
            throws Exception {

        CustomerQueries customerQueries = new CustomerQueries();

        Customer customer = customerQueries.getCustomerById(1);

        assertNotNull(customer);

        assertEquals(
                "Marcus",
                customer.getFirstName());
    }

    @Test
    void shouldCreateAndRetrieveCustomer()
            throws Exception {

        CustomerQueries customerQueries = new CustomerQueries();

        Integer customerId = customerQueries.createCustomer(
                "Marcus",
                "Campos",
                "marcus2@test.com");

        Customer customer = customerQueries.getCustomerById(
                customerId);

        assertNotNull(customer);

        assertEquals(
                "Marcus",
                customer.getFirstName());
    }
}