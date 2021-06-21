package com.example.registerservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/21/16:20
 * @Description:
 */
public class RegisterUtil {

    /**
     * 生成挂号的随机编号
     *
     * @return 病人编号
     */
    public static String getRegisterNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        String no = "GH" + format + (long) (Math.random() * 1000000000);
        return no;
    }
}
