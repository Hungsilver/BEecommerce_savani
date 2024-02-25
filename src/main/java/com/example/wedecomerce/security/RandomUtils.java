package com.example.wedecomerce.security;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class RandomUtils {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateRandomAlphanumericString() {
        return RandomStringUtils.random(20, 0, 0, true, true, (char[]) null, SECURE_RANDOM);
    }

    public static String generateRandomOTP() {
        return RandomStringUtils.random(6, 0, 0, false, true, (char[]) null, SECURE_RANDOM);
    }

    public static String generatePassword() {
        return generateRandomAlphanumericString();
    }

    public static String generateOTP() {
        return generateRandomOTP();
    }

    static {
        SECURE_RANDOM.nextBytes(new byte[64]);
    }
}
