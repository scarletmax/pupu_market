package com.cykj.marketadmin.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000116689788";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY ="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDa25Tap7iAt18o9tZmhyONH3vFZurlWUyhcUSfHScM+zLeD8O9Z8Os8y092332c4JVhUo8mBHcv71UVlktAcrSsJ3dpV/d2CNstfjmiPP2ZeKXtyXuOACNZDW55eksk/ZrKnrM5YbBEuP+QD4tFs+0jbYQhxaJjzHb2KPTcUogCsXZZIxDJvJY47h+oa2lj09VSFSf1EdmHF4CFwknY0e4/BXdc5g9M62n+X54hAuu//Kpw2EUSzhzCBhkpO4XwdhyywMmUtxYdDAj4CWlT2AjcZ+iG/zjDpHmceedSBbIFai6TB5up5ol5XzyUwuCwiEgQHhjwwMQnAwAJucYm+PvAgMBAAECggEBAL31Rt7+Ims+Pc89Z9w3wYi04eX1rT4B4zxhJrGASSvAQGdzgW69SJ6ttv/wqgUmPuLhvQyY5TAYEEnKZL5mxtdWSr9d0bao6h5qV64pAq9DwYfzhG2emAQhDWzb/CYgCwr7JPkA45RjRBajRhQ2r3NEaNkxl0MwUZNDFvboZvElLZC2o+BtD0ac/u9ZGgzhhiGS+PPuZPZuMH8/r7+LcojAn/Pyzk6zmpk+Q5CmRe/YjNL/FINrMM//WbFZavG/Tc4xZyWJ0GAG7AGlUIqCWgSgUFqJ9+Z7rpoOdrwBpR7J2eyNnYpsXEfKBNZZnHUSNWaMVgqGz/QEtTJdxIRnuvECgYEA8kEwRJcV26ppajnGtCCAlb7pqwFFnww6JLs5NCZ7S/DXUynExZLlnaDDkcrVbbRzlZR50PQNC9BlHxguJJsANC0cOOSCMu491wPKKOHSLhqlVoCifquj6KQjQdEALEKuqse5GV6WLvnfvuKUeOI8JbQzDU40pvTJaW4Dlj1rerkCgYEA50aL/cvz7UrQT8ngHxXRIatRqIoo2mIyA0hjCW7URWiVoQpSjHgduxLU2tbH9OL8dUw2Iv3tmyFAgnAwLrO6fhHsBsCrfilgk2v8G9zWDgWQrnyFpZWiwlPpqaJ/NCkHxuQ7vw7O8GhXQIYayuy/z5xznLq96gAIsG1thSIB3+cCgYEAs0vuJoXQBrGcraMvXrfDk5EmLouVdL6+9dqf3uowTSdmpsV+PmCXk0+eD3SY/EYXWfj3I+DNGxZVEWt7E1qpDvToM29ksb9Eg7PpVtK0Fa1g+6HfInN0r8Vz1s2SHDAKSJnjdFReQUxs/kGCc+m1bI5vToS4UW1Q+LgU7Yht2PkCgYEAyxx1zYrUys0tbSVKI4Kxi/Q9XtsXTdN3QNLNx3cCDYLwBeJe5OaIlcbQEPEX4sWGGi24TbrcdaUaVnPYnOtTGWz78GI9Oit0mYP4gS/M/bt9eP/7D5T+v9OaHlSLim+OWOoQXpbOvuuj1RLxbM3HFrm7/yUxrNQizW8NBCL9qnkCgYBmA86gD+djgZInFv/k0sTlhwf+VtnBUOmV+Kp8HcFLQ4dsKMDArllx8grn/3CkSIFyjYR48u8aT2Zff58kKLeXgsBCUuwRuQ7hTcSi9uRYhaJWAihFE4VKhFh7lrxuX6w2zlhIgumlk/tj9DTtE5InKstTp2R6kCSPpeBQUTLHjQ==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqKmdTNCJnws0LQP4O3c57QzKipJFCCRwpQWOWf9j1W64l3N9CcWZqoPcEhLx76HWP9MfcAU4DGbOoKXnHa8TMItUPAkpyxdHDat96B1dzyoy1FEOa4cRYAgwluU2f7qhIY4+uwSao19JPqDH0sYPDL9H+hUBUNHzfXtEHXsGfy6Q7WlC4Ue8iEa4tZ8ojFP4puheoLeoaLSvD3BOJQ6rZ7st0XZMYvc016m5pI+fvUPDmUOLksln39sIkHN9dDvtiXOClDbk5qL9cSr0TcSOOZ9/EhR+BEMlzUqN89esp2/lTUnSZz3iSqQAdKAFmlF5ymqnmulHzvuQspWNOMLaVwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "F:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
