package com.example.readhaven.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Properties;

public class ConfigLoaderUtils {

    private static final Properties properties = new Properties();

    // This is for the reason that, before anyone uses ConfigLoader, load all configurations
    // into memory
    static {
        loadProperties();
    }

    // Property Values are loaded here and made available in the project
    private static void loadProperties() {
        try {
            // Loading the .env file from the main directory, and ignoring if not found
            Dotenv dotenv = Dotenv.configure()
                    .directory("user.dir")
                    .ignoreIfMissing()
                    .load();

            // Mapping variables to properties
            properties.setProperty("database.url", dotenv.get("DB_URL"));
            properties.setProperty("database.username", dotenv.get("DB_USERNAME"));
            properties.setProperty("database.password", dotenv.get("DB_PASSWORD"));
            properties.setProperty("database.driver", dotenv.get("DB_DRIVER"));

        } catch (Exception e) {
            System.out.println(".env file not found");
        }
    }

    // Property values loaded in the above function, can be accessed via this method
    // Get a specific set property by providing the key (like database.url and so)
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
