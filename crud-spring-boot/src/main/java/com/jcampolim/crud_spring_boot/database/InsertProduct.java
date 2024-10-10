package com.jcampolim.crud_spring_boot.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertProduct {

    public static void insertProduct(Connection connection, String name, float price, int stock) {
        try(
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, price, stock) VALUES (?, ?, ?)"))
        {
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, price);
            preparedStatement.setInt(3, stock);

            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred:" + e.getMessage());
        }
    }

}
