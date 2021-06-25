package com.example.payservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class PayUtil {

    private final String APP_ID = "2021000117676880";
    //应用私钥
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDS9rc/dN8nifh90nB5pX6SFmjPJ3WooErT8+99EdYJQFaTjjURTM+fCM+lcmkALh+C88HY06eRzy9gbGP89xEIxIQpAKWters9K9Ox4RwC35zxcGI2Q4xTh9FCmJFall0uvvyPYE5oCPG2WJKfks2k2x5+qtB4FOGDiIl4eFCTwH9q6aNoX3/P8cvchPDAOMHv/57JdMD4I0/fkTFaJ0V7PTCrNl9P3jJieZyDkY82Dgvc4U9CMjy3udMJYQ+z7iLRQfEcz3zsjG2oyIFFxp9CbUKgrchf9Ja+HJiN9S2Oc/6kAceT2U9Brbnse/z/nymjOESRnMkByJIn5hZMpAlNAgMBAAECggEBALfEMdwU8k5+4Pa5WUCd6KNY4fORa+x3tLbsxrEr2EY2xTPDrHZlcnYWNsrn3o9Jnil0LGez90QMNjjIMlEo5q28gWM2LRvwzSl8A+vvK3dVUmD+hI7ASHx60s4wGG3QjVsrAtXiDmqRX/x3K0HVn0z7kpTENtRjXA434YgPRiFs+ABu+L03BMxV+rAOq66wcDyr5/n9vRhOgVQGWuwd9LW0hT7dCMCNb/OojE80iD1RpyLZ90Uksq1xHrlI3Icb7qYfEUxXySYr95+JfdItrP/TXJ/KEWK7v7tWItq213OjwPdsxni+0Sd6AHxay17e073//NvPTf8Ca1JOXd4GIAECgYEA9mNBDfMMQK8rGds8Q8KPbV9oELueLGC9v9NhkDPWNwzG4TAawNRnbo3ok4AzagBd7UQKjaUm7rENEd67gVgbDycznECaXzkQLKY39lbydZqmqRHraDoIJqapuGxq5Fyj1wnUrMl7n+d6HEKJDXMVl9H6w8sXtb9JWFci6W/DSZUCgYEA2zGsDvI9toDMsNR4esdLDp9juzq6NTXEKAAZCIdaYUj3xKGy1OD1+TTjHba8djS1+6KXgAn6HyoaC5hjcwXCehzK7Q9lPCG9jikEW3RfpW7y9OE9kCmYewmTK63ECLeTE2QEEt+UdOuoh+U8Fb9u8GWHSK/K6ie7l5HwTfSJgtkCgYBm+ShxKgkO56a90bCoKSJEdcFKbP84UN48051M5T08GKzt5Grp+FuaCtkO/F+Ah9K5nNxEQqe4zmpF866t6iK0/I9HWICsF285Geb9n20J1a6dro2SK97IOJNqLnWmJ0maT9OAu1xdgiK4uN4KrvRxVSLWvYSVQvLmZtSCd2FI2QKBgEByYVlfpf9z7TsMrYPD9vCMsqEJCli8vzjXloSob01tS9QXiuIGZqvn/eLtqInEw8EBtDOkO1NQaKoCGzNlfSG0N4Ht5eEBNp+Gtc5B8CFO9sZDN3ucj0WVshzEkX/Sob6wyHXYIOkjpMCYCMuIJpEt+NHJRgsEtaZB9XqmLIw5AoGAFzRp2TzAt8Bxzl+o6oDlIHUg8qNOlZy05so1Fg+IkJk2lQSbL5B9uYDyaGKoWGYhv3WCsIZA1WYW7W9VKAjRO8XJh6BF1Vl7ZWk5iswI76T5hhNTWObbYNjMUGxgyncqAvb4wU43zT6OQ/6R/OAZsR2hMQN31VZjQSXA4AQmgxw=";
    private final String CHARSET = "UTF-8";
    //支付宝公钥
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtU0G/j+TYfEQXS3Nqs5wy07xzjrb1v2a6BSoqVdbgUsCC2u7Q1pU+ig69n7XrUJ/qbsEovMMrwz+wNsQXnx6GPHXoqoD8aJyj+MNRt25tLLbvvppA5qkqCYTnohQuSAY2GpR9vy/vzQqUW3LVCF6lP7I6iIq4TACUG5Oo5YfOLqZosEmSZFRFlRgZ2xYitwMnbfLW2CqbFFE8Q4MuHKGnjPT3WqJ0YeR03ZonPMc+UBGAYyfB4Fb2TNAyfvF5dHN6S0vJA/8F8EiCZXsgigG9DkoF5CEgbUpx0vbGqdCNuXR3dqo9K3TBgCtYgea/EkHOx/A7eD3pYl7s//bm35aRQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8080/";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8080/";


}
