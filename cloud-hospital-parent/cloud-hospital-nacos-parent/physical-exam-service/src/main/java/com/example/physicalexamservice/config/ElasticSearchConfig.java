package com.example.physicalexamservice.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * 配置了 - 配置 - ElasticSearch
 *
 * @author Alnwick11AtoZ 松
 * @date 2021/6/22
 */
@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("192.172.0.163:9200")
//                .build();
//        return RestClients.create(clientConfiguration).rest();

        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost",9200,"http")
        );

        return new RestHighLevelClient(builder);

    }


}
