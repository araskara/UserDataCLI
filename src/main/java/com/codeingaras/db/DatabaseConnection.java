package com.codeingaras.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:dataExp.db";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
