package com.epam.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomator {
    public static String userName = RandomStringUtils.randomAlphabetic(8);
    public static String email =RandomStringUtils.randomAlphabetic(8) + "@me.com";
    public static String password = RandomStringUtils.randomAlphabetic(8);
}
