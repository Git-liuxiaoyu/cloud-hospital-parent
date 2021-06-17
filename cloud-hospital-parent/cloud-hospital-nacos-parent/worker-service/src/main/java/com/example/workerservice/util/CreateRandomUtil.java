package com.example.workerservice.util;

/**
 * 创建随机数工具
 */
public class CreateRandomUtil {

    /**
     * 创建随机验证码
     * @param isNumber 是否是纯数字
     * @param length 验证码长度
     * @return
     */
    public static String createRandomVerifyCode(boolean isNumber, int length){
        String resultStr = "";
        /* 判断是否是纯数字 */
        String codeContent = isNumber ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        boolean flag = true;
        do {
            int count = 0;
            for (int i = 0; i < length; i++) {
                double randomCode = Math.random() * codeContent.length();
                int code = (int) Math.floor(randomCode);
                char c = codeContent.charAt(code);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                resultStr += codeContent.charAt(code);
            }
            if (count >= 2) {
                flag = false;
            }
        } while (flag);
        /* 返回字符串 */
        return resultStr;
    }

}
