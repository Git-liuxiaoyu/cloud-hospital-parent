package com.example.registerservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/19/10:32
 * @Description: 病人工具类
 */
public class PatientUtil {

    /**
     * 生成病人的随机编号
     *
     * @return 病人编号
     */
    public static String getPatientNo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date());
        String no = "WONIU" + format + (long) (Math.random() * 1000000);
        return no;
    }

    public static void main(String[] args) {
        System.out.println(getPatientNo());
        System.out.println(getPatientNo().length());
    }

}
