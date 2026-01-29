package com.example.readhaven.config;

import com.example.readhaven.utils.ConfigLoaderUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {

    private static HikariDataSource dataSource;

    static {
        initializeDataSource();
    }

    // Database connection using the values is initialized here
    private static void initializeDataSource() {
        try {
            // Load class driver
            Class.forName(ConfigLoaderUtils.getProperty("database.driver"));

            // Configure Connection Pool
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(ConfigLoaderUtils.getProperty("database.url"));
            config.setUsername(ConfigLoaderUtils.getProperty("database.username"));
            config.setPassword(ConfigLoaderUtils.getProperty("database.password"));

            // Connection pool setting
            // (We can also set it in the .env file)
            config.setMaximumPoolSize(10);      // 10 requests
            config.setConnectionTimeout(30000); // 30 seconds
            config.setIdleTimeout(600000);      // 10 mins
            config.setMaxLifetime(180000);      // 30 mins

            dataSource = new HikariDataSource(config);

            System.out.println("Database connection pool initialized successfully");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
            throw new RuntimeException("Database driver not available", e);
        }
    }

    // Database connection created in the above function, is provided in the project via this function
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("Datasource not initialized");
        }
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void close() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
            System.out.println("Database connection pool closed");
        }
    }
}
