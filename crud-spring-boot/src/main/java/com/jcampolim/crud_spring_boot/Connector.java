package com.jcampolim.crud_spring_boot;

import lombok.Getter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Connector implements ApplicationRunner {
    private static final String url = "jdbc:h2:mem:testdb";
    private static final String user = "user";
    private static final String password = "password";

    @Getter
    private static Connection connection;

    @Override
    public void run(ApplicationArguments args) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        createTable();
    }

    public static void createTable() {
        try(
            Statement statement = connection.createStatement())
        {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "price NUMBER," +
                    "stock INT)";

            statement.executeUpdate(createTableQuery);

            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            System.out.println("An error occurred:" + e.getMessage());
        }
    }

}
