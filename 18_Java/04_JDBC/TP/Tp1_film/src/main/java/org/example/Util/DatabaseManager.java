package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static String URI = "jdbc:mysql://localhost:3306/demo_jdbc";
    private static String USER = "root";
    private static String PASSWORD = "Root";

    public static Connection getConnection () throws SQLException{
        Connection connection = DriverManager.getConnection(URI,USER,PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
