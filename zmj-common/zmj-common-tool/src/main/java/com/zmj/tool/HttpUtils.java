package com.zmj.tool;

import javafx.util.Pair;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @dewscribe 针对http优化
 * @date 2023/10/18 15:21
 */
public class HttpUtils {

    static CloseableHttpClient httpClient;

    static {
        //注册registry
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", PlainConnectionSocketFactory.getSocketFactory())
                .build();

        //注册连接池
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);

        connectionManager.setMaxTotal(500);
        connectionManager.setDefaultMaxPerRoute(500);
        connectionManager.setDefaultSocketConfig(
                SocketConfig.custom().setSoTimeout(15, TimeUnit.SECONDS).setTcpNoDelay(true).build()
        );

        connectionManager.setValidateAfterInactivity(TimeValue.ofSeconds(15));

        //requestConfig对象设置优化
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(1))
                .setConnectionRequestTimeout(Timeout.ofSeconds(1))
                .setResponseTimeout(Timeout.ofSeconds(1))
                .build();


        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .disableAutomaticRetries()
                .build();

    }

    public static String post(String url,
                              List<Pair<String, String>> pairList, Map<String, String> headMap) throws Exception{
        url = url + "?" + buildParam(pairList);

        HttpPost httpPost = new HttpPost(url);

        if (Objects.nonNull(headMap) && headMap.size() > 0) {
            headMap.forEach((key, value) -> {
                httpPost.addHeader(key, value);
            });
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }finally {
         if (null!=response){
             EntityUtils.consume(response.getEntity());
         }
        }

    }


    public static String buildParam(List<Pair<String, String>> pairList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair<String, String> pair : pairList) {
            stringBuilder.append(pair.getKey()).append("=").append(pair.getValue()).append("&");
        }

        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


}
