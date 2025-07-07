package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;
    private static final String DB_URL = "jdbc:derby://localhost:1527/wildlife";
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading JDBC driver. Application cannot start.", e);
        }
    }

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                System.out.println("Connected to WildLife database");
            }else{
                conn.close();
                System.out.println("Connection to WildLife database closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.", e);
        }
        return conn;
    }
}
