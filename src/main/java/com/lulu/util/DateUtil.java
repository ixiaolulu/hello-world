package com.lulu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/22 15:06
 */
public class DateUtil {
    public static final String NORMAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getDateString(String type, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(date);
    }
}
