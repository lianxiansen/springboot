package com.kamfu.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Util {
	   /**
     * 加密方式
     */
    private static final String ALGORITHM_NAME = "MD5";
 
    /**
     * 默认加密次数
     */
    private static final int DEFAULT_ITERATIONS = 2;
    
    /**
     * 返回加密次数
     *
     * @return private static final int HASHITERATIONS 加密次数
     */
    public static int getDefaultIterations() {
        return DEFAULT_ITERATIONS;
    }
    
    public static String getRandomSalt() {
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }
    
    public static String encrypt(String originalPassword,String randomSalt) {
        SimpleHash simpleHash = new SimpleHash(ALGORITHM_NAME, originalPassword, randomSalt, DEFAULT_ITERATIONS);
        String encryptionPassword = simpleHash.toString();
        return encryptionPassword;
    }
    public static String encrypt(String originalPassword) {
        SimpleHash simpleHash = new SimpleHash(ALGORITHM_NAME, originalPassword, getRandomSalt(), DEFAULT_ITERATIONS);
        String encryptionPassword = simpleHash.toString();
        return encryptionPassword;
    }
}
