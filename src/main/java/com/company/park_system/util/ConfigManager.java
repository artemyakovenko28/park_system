package com.company.park_system.util;

import java.util.ResourceBundle;

public class ConfigManager {
    private static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("config");

    // ConfigManager retrieves information from config.properties
    private ConfigManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
