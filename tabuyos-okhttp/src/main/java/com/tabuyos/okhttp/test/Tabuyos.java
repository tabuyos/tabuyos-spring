package com.tabuyos.okhttp.test;

import okhttp3.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Tabuyos
 * @Time 2020/7/10 13:42
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>(7);
        map.put("user", "tabuyos");
        map.put("age", "21");
        String url = "http://localhost:8229/tabuyos";
        String json = map.toString();
        System.out.println(run(url));
        System.out.println(post(url, json));

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Thread.sleep(1000);
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.before(timestamp1));
    }

    private static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    private static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }
}
