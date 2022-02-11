package com.hupu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getCurTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
