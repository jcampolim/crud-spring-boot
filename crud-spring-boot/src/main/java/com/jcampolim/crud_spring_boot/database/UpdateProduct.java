package com.jcampolim.crud_spring_boot.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {

    public static void updateStock(Connection connection, String id, int stock) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET stock = ? WHERE id = ?")
        ) {
            preparedStatement.setInt(1, stock);
            preparedStatement.setNString(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Data updated successfully!");
        } catch (SQLException e) {
            System.out.println("An error occurred:" + e.getMessage());
        }
    }

    public static void updatePrice(Connection connection, String id, float price) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET price = ? WHERE id = ?")
        ) {
            preparedStatement.setFloat(1, price);
            preparedStatement.setNString(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Data updated successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred:" + e.getMessage());
        }
    }

}
