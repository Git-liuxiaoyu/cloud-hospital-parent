package com.example.outpatientservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoUtils {

    public static String getNoUtils(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        return format+ (long) (Math.random() * 1000000);
    }

}
