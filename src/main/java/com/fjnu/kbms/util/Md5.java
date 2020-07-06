package com.fjnu.kbms.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author aabbcczhy
 */
public class Md5 {

    public static String encodePassword(String password,String salt) {
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleHash result = new SimpleHash("md5", password, byteSalt, 2);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Md5.encodePassword("123","张三"));
    }

}
