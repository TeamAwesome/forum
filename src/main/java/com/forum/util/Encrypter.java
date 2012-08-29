package com.forum.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class Encrypter {

    private static Logger logger = Logger.getLogger(Encrypter.class.getName());

    public String encryptUsingMd5(String input) throws UnsupportedOperationException {
        String md5;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            String salt = "&jdsL874343$%^&*(jcdfdsfe.rkewrdsf%^&*() and by  the  way Lu and Wolf have worked on this.";
            messageDigest.update((input+salt).getBytes(), 0, input.length());
            md5 = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            logger.severe("Failed to create md5 of input due to NoSuchAlgorithmException with message: " + e.getMessage());
            throw new UnsupportedOperationException("Failed to create md5 of input due to NoSuchAlgorithmException", e);
        }

        return md5;
    }
}
