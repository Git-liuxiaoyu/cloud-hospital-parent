package com.example.payservice.util;


/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101600701680";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFs0qAEmTfknzjwmcpN4aAcHnBJD/uDjUFpe4A6Ko73+jyFwOO6jsi6V+RlEnFVoiN5PFHSdVoUXYZyJxA0cMOX6FQibZcI+zOEc4P3S2a42Mh0qSdvk2BbtqLYNsYE0A6m7UKZ4MRH7AQuJaObykd+MaX6n/IfQX2uARQOkX+IP9/Vh1KGymFF5olu98MRsrjyopbsH7xgCszgCIxFYSwYSAlt5XUeGpTtVUXh/DUekWLj7d+cpwHpdQzVBfp1TnbR9unqyPfohx9PykisjoteovFrg6Zx8sx+rpxi+R/ifiCXIHXNFkJ5NUCn8ykVfRpJevGOuX+tbzZ0bDpwJePAgMBAAECggEAY+LY6+nSFv3X9EjOzYpAIEDnlZZBdNaEYl3e/CrW07iqzgLHk8QGvkRgM+D3ZEkL6AZ9A+dzWmZRt12a7wpHkbt8RzE7XocwaZv/uPZjFe5/p0s51OfR+7sX5z1LMidfuumNTeKblvV3kmZ1hKAjtdKge+qj4OMWy4YbIt0GYZ6sJqLgX7F52QAObipkXffgzHP1bvKvTLDKUJAPGsLwbltwbDt2NL9zlPhJl2GLZqvt2ggKpvkchw49VPj53kZxJI7BxZwb7jq5L2Mv5NJG3LvXVP0J3nAAzX4e5LyB6eBU2Ld3rMKnpKp1rpZOsg26RjVIypX8RiqwRRn5tBumAQKBgQDIxdvtWVeADGCuoP9auis5sriMAgX8/tkwSMIBCR9n6pSZ7pYGCvMrSdI/AnaT0nB/4UtZAfmDL01BcUG0ufFB5GiwEaBSABqvM05XoI2u2LIldoCiAGg9EkChrLysKeK94ZNj8A8kmTWVoHPAVXXJ7pOHcjpqPb1RtgoF5MyagQKBgQCqekeci3pMJmWWdZnGkIOp2QcxJWPzzCYXXRbJVUrpxEMtQjSsyJogmIhrnNDZdOb/4/A/qfPAOGv1bMLjZRg0brXk96uW6hD7hoxMU6updpY/Qhf7kjil9/7hp8tOQtbzjmPT0DC3SxSQg7qaVZuY2oyf9IOfC7ET9cnUFXqKDwKBgEB7Cz8XSnrdfs+W9Wv2DpvhQlP08mdmkepn86bRfzyookEt1xDpw19LvjJuYBbppyfq+4ACmlf/gRhbf3bDoTBAYz7o6kxrrCZInAiYj+hvwAc4H+fnqZKzof5Ks+23JhNFt0iJeNOQQR1lAsfqqoHIFamSjiBA4+SySlXKPcwBAoGADkPlMihJt42O+qQklgUJv3C1tVsXnhL7LQFRIs/MUPtnU6YymjK/EvMwlzCsGUY6/jaop+skxnTyM7tCI50WBW0uM1a2OQ6lFScRHmHx/2A4+lohf5+gteKmpWNRE99r9T15BQRqzyutMNqVBs0bFBNVqRzg1rI3wx/SH7kcY+kCgYEAvRL+5Ec0lDsCxhYSH1NTSVoytoe/dMzp9O99Qpat2bSRS+WVU2ezbHzmLf/4cfODw0RG6b9iCT5qC7aH8CsGpIkQuFoSRWUC2jeAUQi/V6khGJFDVYYw1vKrNxLP1nBIMpQB2FBm7S7Hez6cT7ZyLoyxIz134ZogZxFpcim0UOA=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnrXlREef+TfVquFbHthD+Zdplt6I7p2cKfdTRcu1Q5v5BjKClOe0jAM+LczLhxAJ5B5CIgQMCVxtG4xpR0u9Z2aZHnt8imc7Ow++D9VB5vn6v9zPzfn6/j4ZrBR6wyyEo1PfAToJGNJ/FH2PN8pQiC4/5xUfbGAWoFphxlh2rlxgmtTIvvl7r+NGr1I0sH/vg1w5qHqe8gcnBbpJXB/25J+7ZIwKnap0gy5pg6cmJuFAp9H19wv6jNTBt108bectsVDiB/yX9sIoD1km3xgPEYLY3egN99o09Wpa3Lg9MggYKcn3hxKviijxDjg0RPmsI11h5FvLtBIRmcZ/o2wHxQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://ylrc.free.idcfengye.com/pay/alipay_notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://ylrc.free.idcfengye.com/pay_log/list";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	//public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    
}

