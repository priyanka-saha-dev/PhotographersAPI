package com.demo.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(original);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128); // AES-128
        return keyGen.generateKey();
    }

    /*
    * Example USAGE
    * */
    public void applyEncryption() throws Exception {
        SecretKey key = EncryptionUtil.generateKey();
        String encryptedSSN = EncryptionUtil.encrypt("123-45-6789", key);
        String decryptedSSN = EncryptionUtil.decrypt(encryptedSSN, key);

        System.out.println("Encrypted: " + encryptedSSN);
        System.out.println("Decrypted: " + decryptedSSN);
    }
}
