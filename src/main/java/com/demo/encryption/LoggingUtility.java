package com.demo.encryption;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingUtility {

    public static void logUserDetails(String name, String email, String ssn) {
        String maskedEmail = email.replaceAll("(?<=.{2}).(?=.*@)", "*");
        String maskedSSN = ssn.replaceAll("\\d(?=\\d{4})", "*");

        log.info("User: Name={}, Email={}, SSN={}", name, maskedEmail, maskedSSN);
    }
}
