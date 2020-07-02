package com.tabuyos.pay.properties;

import com.tabuyos.pay.constant.AlipayConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Tabuyos
 * @Time 2020/7/1 10:33
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@ConfigurationProperties(AlipayConstant.ALIPAY_PREFIX)
public class AlipayProperties {

    private String protocol = "https";
    private String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    private String appId;
    private String appPrivateKey;
    private String format = "json";
    private String charset = "UTF-8";
    private String timeout = "30m";
    private String alipayPublicKey;
    private String signType = "RSA2";
    private String productCode = "QUICK_MSECURITY_PAY";
    private String notifyUrl;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "AlipayProperties{" +
                "protocol='" + protocol + '\'' +
                ", gatewayUrl='" + gatewayUrl + '\'' +
                ", appId='" + appId + '\'' +
                ", appPrivateKey='" + appPrivateKey + '\'' +
                ", format='" + format + '\'' +
                ", charset='" + charset + '\'' +
                ", timeout='" + timeout + '\'' +
                ", alipayPublicKey='" + alipayPublicKey + '\'' +
                ", signType='" + signType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }


}
