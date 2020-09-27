package util;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class HashPassword {
    // lib to encrypt and decrypt password
    static StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();

    //method to encrypt password
    public  static String encryptPassword(String plainPassword){
        return encryptor.encryptPassword(plainPassword);
    }

    // method to decrypt a password

    public static boolean validateEncryptedPass(String plainText, String encryptedPassword) {
        return encryptor.checkPassword(plainText, encryptedPassword);
    }

}
