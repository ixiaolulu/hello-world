package com.lulu.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/22 13:50
 */
public class HMACSHA1Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(HMACSHA1Util.class);

    public static String hash_hmac(String algorithm, String msg, String key, String charset) {
        if (StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        try {
            Mac mac = Mac.getInstance(algorithm);
            SecretKeySpec spec = new SecretKeySpec(key.getBytes(charset), algorithm);
            mac.init(spec);
            byte[] bytes = mac.doFinal(msg.getBytes(charset));
            return bytes2Hex(bytes);
        } catch (Exception e) {
            LOGGER.error("加签失败，algorithm:{},msg:{},charset:{}", algorithm, msg, charset, e);
//            throw new Exception("");
        }
        return null;
    }

    private static String byte2hex(final byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
            stmp = (java.lang.Integer.toHexString(b[n] & 0xFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs;
    }


    private static String byteToHexString(byte ib) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0f];
        ob[1] = Digit[ib & 0X0F];
        return new String(ob);
    }


    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        char[] res = new char[bytes.length * 2]; // 每个byte对应两个字符
        final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0, j = 0; i < bytes.length; i++) {
            res[j++] = hexDigits[bytes[i] >> 4 & 0x0f]; // 先存byte的高4位
            res[j++] = hexDigits[bytes[i] & 0x0f]; // 再存byte的低4位
        }
        return new String(res);
    }


    public static void main(String[] args) {

    }
}
