package marcus_campos.selenium_java_framework;

import marcus_campos.selenium_java_framework.database.DbClient;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseconnectionTest {

    @Test
    void shouldConnectToDatabase() throws Exception {

        DbClient dbClient = new DbClient();

        Connection connection =
                dbClient.getConnection();

        assertNotNull(connection);

        System.out.println("Connected to PostgreSQL");
    }
}