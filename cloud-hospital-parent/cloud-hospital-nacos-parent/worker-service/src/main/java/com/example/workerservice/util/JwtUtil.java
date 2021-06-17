package com.example.workerservice.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

/**
 * 工具类 - JwtUtil
 */
public class JwtUtil {

    /**
     * 过期时间50分钟
     */
    private static final long EXPIRE_TIME = 50 * 60 * 1000;
    /**
     * jwt 密钥
     */
    private static final String SECRET = "WoNiuHospital";

    /**
     * 生成签名
     *
     * @param username
     * @return
     */
    public static String creatSign(String username) {


        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将 user id 保存到 token 里面
                    .withAudience(username)
                    // 50分钟后token过期
                    .withExpiresAt(date)
                    //.withClaim()
                    //.withSubject(userName)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new CreateSignError();
        }
    }


    /**
     * 根据token获取account
     *
     * @param token
     * @return
     */
    public static String getAccount(String token) {
        try {
            String account = JWT.decode(token).getAudience().get(0);
            return account;
        } catch (JWTDecodeException e) {
            throw new JWTDecodeException("获取account出错");
        }
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("token 无效，请重新获取");
        }
    }

    /**
     * 自定义业务异常
     **/
    static class CreateSignError extends RuntimeException {
        public CreateSignError() {
            super("签名错误");
        }
    }

}