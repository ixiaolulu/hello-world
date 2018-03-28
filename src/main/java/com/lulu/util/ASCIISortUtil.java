package com.lulu.util;

import java.util.*;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/22 11:32
 */
public class ASCIISortUtil {

    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appid", "wxd930ea5d5a258f4f");
        paramMap.put("mch_id", "10000100");
        paramMap.put("device_info", "1000");
        paramMap.put("body", "test");
        paramMap.put("nonce_str", "ibuaiVcKdpRxkhJA");

        String str = sortKeyASCtoString(paramMap);
        System.out.println(str);
    }

    public static String sortKeyASCtoString(Map<String, String> map) {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<String, String> tempMap = list.get(i);
            sb.append(tempMap.getKey() + "=" + tempMap.getValue()).append((i == (list.size() - 1)) ? "" : "&");
        }

        return sb.toString();
    }

}
