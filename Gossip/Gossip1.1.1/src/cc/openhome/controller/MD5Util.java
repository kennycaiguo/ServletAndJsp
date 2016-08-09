package cc.openhome.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 加密密码模块
 * Created by zhuxinquan on 16-3-6.
 */
public class MD5Util {
    public MD5Util() {
    }

    public static String md5Encode(String s){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = new byte[0];
        try {
            byteArray = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for(int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if(val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
