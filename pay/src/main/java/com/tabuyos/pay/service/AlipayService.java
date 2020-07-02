package com.tabuyos.pay.service;

import com.aliyun.tea.TeaPair;
import com.tabuyos.pay.model.Product;

/**
 * @Author Tabuyos
 * @Time 2020/7/2 11:00
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface AlipayService {

    /**
     * app pay for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String appPay(Product product, TeaPair... teaPairs) throws Exception;

    /**
     * web page pay for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String pagePay(Product product, TeaPair... teaPairs);

    /**
     * wap pay for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String wapPay(Product product, TeaPair... teaPairs);

    /**
     * common create for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonCreate(Product product, TeaPair... teaPairs);

    /**
     * common query for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonQuery(Product product, TeaPair... teaPairs);

    /**
     * common refund for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonRefund(Product product, TeaPair... teaPairs) throws Exception;

    /**
     * common close for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonClose(Product product, TeaPair... teaPairs);

    /**
     * common cancel for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonCancel(Product product, TeaPair... teaPairs);

    /**
     * common query refund for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonQueryRefund(Product product, TeaPair... teaPairs);

    /**
     * common download bill for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonDownloadBill(Product product, TeaPair... teaPairs);

    /**
     * common verify notify for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String commonVerifyNotify(Product product, TeaPair... teaPairs);

    /**
     * huabei create for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String huabeiCreate(Product product, TeaPair... teaPairs);

    /**
     * face to face create for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String faceToFacePay(Product product, TeaPair... teaPairs);

    /**
     * face to face pre-create for alipay.
     *
     * @param product  product for alipay request parameter.
     * @param teaPairs extensive parameter for biz_content.
     * @return String
     */
    String faceToFacePreCreate(Product product, TeaPair... teaPairs);
}
