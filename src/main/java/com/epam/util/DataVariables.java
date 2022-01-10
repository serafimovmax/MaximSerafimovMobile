package com.epam.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ResourceBundle;

public class DataVariables {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("test");
    public static final String PROJECT_NAME = resourceBundle.getString("projectName");
    public static String API_KEY;
    public static final String APPIUM_HUB = resourceBundle.getString("appiumHub");

    static {
        try {
            API_KEY = URLEncoder.encode(resourceBundle.getString("api_key"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
