package com.lulu.model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/2 10:39
 */
public class CompareToTest {
    private static final ConcurrentHashMap<String, String> CACHE_MAP = new ConcurrentHashMap<String,String>();
    public static void main(String[] args) {
       String str = "15300851613";
       str = str.replace(str.substring(3,7),"****");
        System.out.println(str.substring(3,7));
        System.out.println(str);

        Integer t = new Integer(0);
        System.out.println(t.compareTo(1)== 0);
    }
}
