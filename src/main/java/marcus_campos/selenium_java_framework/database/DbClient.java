package marcus_campos.selenium_java_framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbClient {

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                DbConfig.URL,
                DbConfig.USERNAME,
                DbConfig.PASSWORD);
    }
}