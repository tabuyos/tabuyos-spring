package com.tabuyos.pay.controller;

import com.alipay.easysdk.factory.Factory;
import com.aliyun.tea.TeaPair;
import com.google.common.base.Strings;
import com.tabuyos.pay.model.Product;
import com.tabuyos.pay.properties.AlipayProperties;
import com.tabuyos.pay.service.AlipayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * @Author Tabuyos
 * @Time 2020/7/1 10:22
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class TabuyosController {

    private final AlipayProperties alipayProperties;
    private final AlipayService alipayService;

    public TabuyosController(AlipayProperties alipayProperties, AlipayService alipayService) {
        this.alipayProperties = alipayProperties;
        this.alipayService = alipayService;
    }

    @GetMapping("tabuyos")
    public String tabuyos() throws Exception {
        Product product = Product.create().subject("Tabuyos test alipay").outTradeNo(UUID.randomUUID().toString()
                .replaceAll("-", "")).totalAmount("0.01").build();
        String response = alipayService.appPay(product, new TeaPair("notify_url", "http://y7bds5.natappfree" +
                ".cc/notify"));
        System.out.println(response);
        String encode = URLDecoder.decode(response, StandardCharsets.UTF_8.name());
        System.out.println(encode);
        return response;
    }

    @PostMapping("notify")
    public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> parameters = getParameters(request);
        Boolean signature = Factory.Payment.Common().verifyNotify(parameters);
        System.out.println(signature);
        response.getWriter().println("success");
    }

    @PostMapping("refund")
    public void refund() throws Exception {
        Product product = Product.create().outTradeNo("72df86a8cdc343d6964b4c8bcedeb00b").refundAmount("0.01").build();
        String refund = alipayService.commonRefund(product);
        System.out.println(refund);
    }

    public static Map<String, String> getParameters(HttpServletRequest request) {
        Map<String,String> params = new HashMap<>(30);
        Map<?, ?> requestParams = request.getParameterMap();
        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }
}
