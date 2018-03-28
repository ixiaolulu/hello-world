package com.lulu.util;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/26 14:12
 */
public class StringUtils {

    public static void main(String[] args) {
        String[]  obj = new String[]{"大白","小黑","123","dasda"};
        String str = org.apache.commons.lang3.StringUtils.repeat("{}", ",", obj.length);
        System.out.println(str);
    }

}
