package marcus_campos.selenium_java_framework.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerQueries {

    public Customer getCustomerById(Integer id)
            throws Exception {

        DbClient dbClient = new DbClient();

        String sql = "SELECT * FROM customers WHERE id = ?";

        try (Connection connection = dbClient.getConnection();

                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                Customer customer = new Customer();

                customer.setId(
                        resultSet.getInt("id"));

                customer.setFirstName(
                        resultSet.getString("first_name"));

                customer.setLastName(
                        resultSet.getString("last_name"));

                customer.setEmail(
                        resultSet.getString("email"));

                return customer;
            }

            return null;
        }
    }

    public Integer createCustomer(
            String firstName,
            String lastName,
            String email)
            throws Exception {

        DbClient dbClient = new DbClient();

        String sql = """
                INSERT INTO customers
                (first_name, last_name, email)
                VALUES (?, ?, ?)
                RETURNING id
                """;

        try (Connection connection = dbClient.getConnection();

                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            return resultSet.getInt("id");
        }
    }

}