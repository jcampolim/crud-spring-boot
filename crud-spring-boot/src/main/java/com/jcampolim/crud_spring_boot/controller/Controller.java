package com.jcampolim.crud_spring_boot.controller;

import com.jcampolim.crud_spring_boot.database.*;
import com.jcampolim.crud_spring_boot.Connector;
import com.jcampolim.crud_spring_boot.Product;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class Controller {

    @GetMapping(value = "/{id}")
    public static Product getProduct(@PathVariable String id) {
        return GetProduct.getProduct(Connector.getConnection(), id);
    }

    @GetMapping(value = "/")
    public static List<Product> getProducts() {
        return GetProduct.getProducts(Connector.getConnection());
    }

    @PostMapping(value = "/insert")
    public static void insertProduct(@RequestParam String name, @RequestParam float price, @RequestParam int stock) {
        InsertProduct.insertProduct(Connector.getConnection(), name, price, stock);
    }

    @PutMapping(value = "/update/stock")
    public static void updateStock(@RequestParam String id, @RequestParam int newValue) throws SQLException {
        UpdateProduct.updateStock(Connector.getConnection(), id, newValue);
    }

    @PutMapping(value = "/update/price")
    public static void updatePrice(@RequestParam String id, @RequestParam float newValue) throws SQLException {
        UpdateProduct.updatePrice(Connector.getConnection(), id, newValue);
    }

    @DeleteMapping(value="/delete/{id}")
    public static void deleteProduct(@PathVariable String id) {
        DeleteProduct.deleteProduct(Connector.getConnection(), id);
    }
}
