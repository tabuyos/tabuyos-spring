package com.tabuyos.pay.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.payment.app.Client;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.aliyun.tea.TeaPair;
import com.tabuyos.pay.model.Product;
import com.tabuyos.pay.properties.AlipayProperties;
import com.tabuyos.pay.service.AlipayService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author Tabuyos
 * @Time 2020/7/2 11:00
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    public AlipayServiceImpl(AlipayProperties alipayProperties) {
        Factory.setOptions(getOptions(alipayProperties));
    }

    @Override
    public String appPay(Product product, TeaPair... teaPairs) throws Exception {
        Client client = Factory.Payment.App();
        for (TeaPair teaPair : teaPairs) {
            client.optional(teaPair.key, teaPair.value);
        }
        AlipayTradeAppPayResponse response = client.pay(product.getSubject(), product.getOutTradeNo(),
                product.getTotalAmount());
        return response.body;
    }

    @Override
    public String pagePay(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String wapPay(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonCreate(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonQuery(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonRefund(Product product, TeaPair... teaPairs) throws Exception {
        AlipayTradeRefundResponse response = Factory.Payment.Common().refund(product.getOutTradeNo(), product.getRefundAmount());
        return response.httpBody;
    }

    @Override
    public String commonClose(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonCancel(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonQueryRefund(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonDownloadBill(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String commonVerifyNotify(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String huabeiCreate(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String faceToFacePay(Product product, TeaPair... teaPairs) {
        return null;
    }

    @Override
    public String faceToFacePreCreate(Product product, TeaPair... teaPairs) {
        return null;
    }

    private static Config getOptions(AlipayProperties alipayProperties) {
        Config config = new Config();
        config.protocol = alipayProperties.getProtocol();
        config.gatewayHost = alipayProperties.getGatewayUrl();
        config.signType = alipayProperties.getSignType();
        config.appId = alipayProperties.getAppId();
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = alipayProperties.getAppPrivateKey();
        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";
        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = alipayProperties.getAlipayPublicKey();
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = alipayProperties.getNotifyUrl();
        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
//        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";
        return config;
    }
}
