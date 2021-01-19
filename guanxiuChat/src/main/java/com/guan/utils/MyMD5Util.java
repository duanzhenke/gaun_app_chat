package com.guan.utils;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 * @author pibigstar
 *
 */
public class MyMD5Util {
    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        String encrypt = MyMD5Util.encrypt("123");
        //37cc4f8e788c409bc31abe00788bd468
        //37cc4f8e788c409bc31abe00788bd468

        System.out.println(encrypt);
    }

}


