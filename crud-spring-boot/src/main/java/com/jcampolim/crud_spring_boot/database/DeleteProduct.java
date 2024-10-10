package com.jcampolim.crud_spring_boot.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProduct {

    public static void deleteProduct(Connection connection, String id) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id = ?")
        ) {
            preparedStatement.setNString(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Data deleted successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred:" + e.getMessage());
        }
    }

}
