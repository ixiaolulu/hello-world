package com.lulu.test.sign;

import com.lulu.util.ASCIISortUtil;
import com.lulu.util.DateUtil;
import com.lulu.util.HMACSHA1Util;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试微信验签
 * @Author: Milo.Ding
 * @Date: 2018/3/22 11:19
 */
public class WeiXinSign {
    public static String apiSecret = "192006250b4c09247ec02edce69f6a2d";

    public static String charset = "UTF-8";

//    public  static

    public static void test() throws Exception {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appid", "wxd930ea5d5a258f4f");
        paramMap.put("mch_id", "10000100");
        paramMap.put("device_info", "1000");
        paramMap.put("body", "test");
        paramMap.put("nonce_str", "ibuaiVcKdpRxkhJA");
        paramMap.put("requestTime", DateUtil.getDateString(DateUtil.NORMAL_PATTERN, new Date()));
        paramMap.put("tradeNo", "2018010202933");

        String stringA = ASCIISortUtil.sortKeyASCtoString(paramMap);

        System.out.println("stringA:" + stringA);

        //.连接商户key
        String stringSignTemp = stringA + "&key=" + apiSecret;

        System.out.println("stringSignTemp:" + stringSignTemp);

        //md5加签
        String md5Sign = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
        System.out.println("md5加签:" + md5Sign);

        //sha256加签
        String sha256Sign = HMACSHA1Util.hash_hmac("HmacSHA256", stringSignTemp, apiSecret, charset).toUpperCase();

        System.out.println("sha256加签:" + sha256Sign);

    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
