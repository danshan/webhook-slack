package com.shanhh.webhook.config;

import org.apache.http.HttpResponse;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author dan
 * @since 2017-03-02 11:26
 */
@Configuration
public class HttpClientConfig {

    private static final String CHAR_SET = "UTF-8";

    /**
     * 最大连接数400
     */
    private static int MAX_CONNECTION_NUM = 400;


    /**
     * 单路由最大连接数80
     */
    private static int MAX_PER_ROUTE = 80;


    /**
     * 向服务端请求超时时间设置(单位:毫秒)
     */
    private static int SERVER_REQUEST_TIME_OUT = 20000;


    /**
     * 服务端响应超时时间设置(单位:毫秒)
     */
    private static int SERVER_RESPONSE_TIME_OUT = 20000;


    /**
     * 功能描述: <br>
     * 初始化连接池管理对象
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @Bean(name = "poolingHttpClientConnectionManager")
    public PoolingHttpClientConnectionManager getPoolManager() {

        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        try {
            sslContextBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build(),
                    new String[] {"TLSv1.2"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", socketFactory)
                    .register("http", new PlainConnectionSocketFactory())
                    .build();
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            cm.setMaxTotal(MAX_CONNECTION_NUM);
            cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
            return cm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean(name = "httpClient")
    public CloseableHttpClient getHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SERVER_REQUEST_TIME_OUT)
                .setConnectTimeout(SERVER_RESPONSE_TIME_OUT)
                .build();
        return getHttpsClient(requestConfig);
    }

    /**
     * 创建线程安全的HttpClient
     *
     * @param config 客户端超时设置
     */
    private CloseableHttpClient getHttpsClient(RequestConfig config) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config)
                .setConnectionManager(this.getPoolManager())
                .setServiceUnavailableRetryStrategy(new ServiceUnavailableRetryStrategy() {
                    @Override
                    public boolean retryRequest(final HttpResponse response, final int executionCount, final HttpContext context) {
                        return false;
                    }

                    @Override
                    public long getRetryInterval() {
                        return 0L;
                    }
                })
                .evictExpiredConnections()
                .evictIdleConnections(5L, TimeUnit.SECONDS)
                .build();
        return httpClient;
    }

}
