/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Andres
 */


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hendrix
 */
public class EncryptUtil {

    public static String encriptarMD5(String cadena) {
        byte[] hashedBytes;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            hashedBytes = digest.digest(cadena.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(
                    "Could not generate hash from String", ex);
        }
        return EncryptUtil.convertByteArrayToHexString(hashedBytes);
    }

    public static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
    
    public static void main(String[] args){
        System.out.println("La clave encriptada es:\n");
        System.out.println(encriptarMD5("1234"));
    }
}
