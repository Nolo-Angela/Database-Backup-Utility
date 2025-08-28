package org.database.backup.DbConnection;

import org.apache.commons.dbutils.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private Connection connection;
    //private String dbName;

    public DbConnect(String dbName) {
        try {
            connection = DriverManager.getConnection(dbName);
            System.out.println("Connected to: " + dbName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
