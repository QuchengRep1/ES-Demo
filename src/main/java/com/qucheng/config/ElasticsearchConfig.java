package com.qucheng.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${qucheng.es.hostname}")
    private String HostName;

    @Bean
    public RestHighLevelClient getClient() {

        String[] split = HostName.split(",");

        HttpHost[] httpHostArray = new HttpHost[split.length];
        for (int i=0;i<split.length;i++) {
            String host = split[i];
            String[] hostIpArray = host.split(":");
            String http = hostIpArray[0].toString();
            int port = Integer.parseInt(hostIpArray[1]);
            httpHostArray[i] = new HttpHost(http,port,"http");
        }

        return new RestHighLevelClient(RestClient.builder(httpHostArray));

    }


}
