package com.wyy.javatrainingcamp.nio;

import okhttp3.*;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class OkHttp {

    public static void main(String[] args) {
        String httpGet = httpGet("https://www.baidu.com/");
        System.out.println(httpGet);
    }

    /**
     * 发起get请求
     *
     */
    public static String httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Post请求
     */
    public static Response httpPost(String url, String jsonStr, Map<String, String> headers) throws IOException {

        RequestBody requestBody = RequestBody.create(MediaType.parse("text/html;charset=utf-8"), jsonStr);
        Request.Builder requestBuilder = new Request.Builder().url(url).post(requestBody);

        if(!CollectionUtils.isEmpty(headers)){
            for (Map.Entry<String, String> mapEntry : headers.entrySet()) {
                if(!Objects.isNull(mapEntry.getValue())){
                    requestBuilder.addHeader(mapEntry.getKey(), String.valueOf(mapEntry.getValue()));
                }
            }
        }

        Response response =  new OkHttpClient().newCall(requestBuilder.build()).execute();
        return response;
    }

}
