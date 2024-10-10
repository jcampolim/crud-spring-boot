package com.jcampolim.crud_spring_boot.database;

import com.jcampolim.crud_spring_boot.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetProduct {

    public static List<Product> getProducts(Connection connection) {
        List<Product> products = new ArrayList<>();

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products")
        ) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                float price = resultSet.getFloat("price");
                int stock = resultSet.getInt("stock");

                System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price + " | Stock: " + stock);
                products.add(new Product(Integer.toString(id), name, price, stock));
            }
        } catch (Exception e) {
            System.out.println("An error occurred:" + e.getMessage());
        }

        return products;
    }

    public static Product getProduct(Connection connection, String id) {
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE id = " + id)
        ) {
            Product product = new Product();

            resultSet.next();
            product.setId(id);
            product.setName(resultSet.getNString("name"));
            product.setPrice(resultSet.getFloat("price"));
            product.setStock(resultSet.getInt("stock"));

            System.out.println("ID: " + id + " | Name: " + product.getName() + " | Price: " + product.getPrice() + " | Stock: " + product.getStock());

            return product;

        } catch (Exception e) {
            System.out.println("An error occurred:" + e.getMessage());
        }

        return null;
    }
}
