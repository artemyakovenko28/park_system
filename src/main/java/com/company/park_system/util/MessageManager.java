package com.company.park_system.util;

import java.util.ResourceBundle;

public class MessageManager {
    private static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("messages");

    // MessageManager retrieves information from messages.properties
    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
