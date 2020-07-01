package com.it.personalblog1_0.utils;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/26 17:58
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**MD5加密工具类*/
public class MD5Util {

    public static String code(String args){

        try {
            //生成MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //根据字节计算md5
            md.update(args.getBytes());
            //digest()最后确定返回md5 hash值，返回的是16位的Hash值
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++){
                //i = byteDigest[offset]&0xff;
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    //用32位表示数值
                    buffer.append("0");
                //进制转换，十进制变十六进制
                buffer.append(Integer.toHexString(i));
            }
            //32位加密
            return buffer.toString();
            //16位加密
            //return buffer.toString().substring(8,24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        String a= "123456";
        System.out.println(code(a));
        /*
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(a.getBytes());
            byte[] b = md.digest();
            for (byte i : b
            ) {
                System.out.print(i+"/");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/
    }
}
