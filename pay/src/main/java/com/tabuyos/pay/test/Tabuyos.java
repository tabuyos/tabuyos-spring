package com.tabuyos.pay.test;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.common.models.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.tabuyos.pay.model.Product;

import java.util.UUID;

/**
 * @Author Tabuyos
 * @Time 2020/7/2 9:48
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {
    //    public static void main(String[] args) throws Exception {
//        // 1. 设置参数（全局只需设置一次）
//        Factory.setOptions(getOptions());
//        try {
//            // 2. 发起API调用（以创建当面付收款二维码为例）
//            AlipayTradeAppPayResponse response = Factory.Payment.App().optional("body", "Apple iPhone11 128G, bigger " +
//                    "than bigger")
//                    .pay("Apple iPhone11 128G", UUID.randomUUID().toString().replaceAll("-", ""), "0.01");
//            // 3. 处理响应或异常
//            if (ResponseChecker.success(response)) {
//                System.out.println("调用成功 " + response.body);
//            } else {
//                System.err.println("调用失败，原因：");
//            }
//
////            Factory.Payment.Common().verifyNotify()
//
////            AlipayDataDataserviceBillDownloadurlQueryResponse trade = Factory.Payment.Common().downloadBill("trade",
////                    "2020-07-01");
////            if (ResponseChecker.success(trade)) {
////                System.out.println("调用成功  " + trade.httpBody);
////            } else {
////                System.err.println("调用失败，原因：" + trade.msg + "，" + trade.subMsg);
////            }
//        } catch (Exception e) {
//            System.err.println("调用遭遇异常，原因：" + e.getMessage());
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
//
//    private static Config getOptions() {
//        Config config = new Config();
//        config.protocol = "https";
//        config.gatewayHost = "openapi.alipay.com";
//        config.signType = "RSA2";
//
//        config.appId = "2021001168660744";
//
//        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
//        config.merchantPrivateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC3/OIF4ac/yV9yRWzDeLgocGuQIQDMNdnkl826aRnWTfZ9lukWJHv2TqSn70hPnXx6KaPa9Pb/qPXB2qz8YSiwsuhhX90xxBI9tmaXCqx4yG586Rrx5nKhHDGD3a8DugZz52AC7Lbz1k60tRBBGM6VNRB1JkFdxBFr/C1smM5B+SN6MDm2+R2LzlyUGVf2CYpTJjwl68p3LZr+oPMsYP4TF2YL5TyEG1C9fCsEIZu3p6Bmwpah+2DcEwEmpqp93S7Ey4NRzl6U+W2z9pm4GHpCaAdTmf8qYi5rXwez/kbL9n5pNS2sosqsjmFfXUKvmxXJ3nGEqPb7KGkZyD7DutE1AgMBAAECggEBAK+hVqEGpwDc2Z/bZdeyhRkVN5h96KUHQthTkK9BZMiN454/UIEykqKsr8EfSYe2bfyvgxqgfKfQQcirVjYVCSKjpfBN8nhvEnqWg5frOHiT2+ShIHeJ5CKnJx0ZoNeN3FsHoz8nd/2LtdYKgVmitJD59pvdyMgZQggy0am4tCuEaMt5NuxvSLq1JggpYVGFtQSiRMwiJ8RdmmGmsT5yXSNEziqqgw1GZO0WXkQ4OgBXRDJ90jKiR4YZC5uvwaYOm/90FP/4s4JaB0/pwWysiXA8ueQmzMMlXXcEQfgqbUoAO3Dv1t+T6xEQ1yJZwciO5P5tyNvUaLLdKcSzzag5tAECgYEA5N69dp4HQ6ZjQckVgFhxBJqOZ/pifLcfxipsoSycewMFTHDhnF0aE4P65I4a3oo6PwmHj0OAhoYwHDGaoptJCNy9BLqmgrAc7DN7vrzXP5JhXbgt8f8cFdpz8G/XJVHsVWlvcp+S2Gn4HTpaXyZghXQqY10MU8UYMoGLpYvyf+kCgYEAzcwm7zQGdD2vUxxmiXYm9xQHfMUbnsd++V2xjv/Au4sFdTRh2c1mH9AcywA2rC9SH/tnyxEBwF+0d4g/5Xzl2aNf/Ya7OYpz+J9QOhZvO1sEQ5irXDhLVNDxqrn0K5tgK2q1l6HncLvcKG+2ZjYCdp1ik648X5z2j8LvZWEho20CgYAY04SPymKVVwYrS6m2a2GPE0jhRIrMZnze3Rk9fn5W5aP8f74pXPwII+fiRPvrKelZjyoSQ0s8zG+Jj2PrwZZxjKhATBLl2D667Ha+4PMkZTeEmAb72iVsxW6QJUGcPb+6IB7Du0WNjiko2nyVF6+eqlQyxRQiPh361IyWX5DliQKBgQCgYMXCyjdxZRT53vslivdIu8ot+OnSbkPMj7Cs8TDAttGVCjJrav94MVYO+Wah/uqwU9sKTIGh6rOYJ40sCY6Schh/Wf0UFYrVKUp7Sjp69i43g4Wfg5tpSL/cvbfEN/zVOP61YY4cs7oZpR1vQA3hZDuLPVB9brRTSqYHyo9NbQKBgGA6kRn3VsRPze2IgMD+wsl20NnCpO7pv5qnWiIgxYh1eVZIt+DjmFDWMXTW51Ud5HCYvIqjQ3epO0KFPewQ42GHk7r6se17hHLVRMo0ouWG3ROdfgjmlK7H2XgLQ5qrT4n2sHuN25uc0BSCg0L8n/KhWPGFmo2gr4j5+9s6IZ6v";
//
//        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
////        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
////        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
////        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";
//
//        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
//         config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgUq2d+uz0/GokOiTAW/+DM/NCAYGPs+KAYxqoNFnUIsulqiz8Lj6oEKTe4fLsoCeCb6ZpJ+U/GQEADjeBufSJAM8IJTPCiPMozAgjwe/EiHE7DxGotNqChsjAzoYt4D3SsQG94xjE03dDTQ7DQygTOs4zp3ME+sQMNEcE7EaN5Ixv/0g1nHdu9o4Nbs29kz1rC8xwkArwhXQWyR3354iPYEkLdTepZBOGCf00RjVVxC1GP3FgCehnDgWlCnu15UDphBUoNeq6xtUAVvbfoJdYc/S0uXslPEE0zYmTt0WEF3vl6Ix7w0nR2cqwrtSD14KMGukjKO3CnHsESJDr9/ujQIDAQAB";
//
//        //可设置异步通知接收服务地址（可选）
//        config.notifyUrl = "http://4xgw2m.natappfree.cc/api/pay/alipayNotify";
//
//        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
////        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";
//
//        return config;
//    }
    public static void main(String[] args) {
    }
}
