package com.example.springdemo.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String password = "springstudent";

        try {
            System.out.println("Connecting to DB: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
