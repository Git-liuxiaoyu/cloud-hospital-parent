package com.example.registerservice.config;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 小刘
 * @Date: 2021/06/25/16:37
 * @Description:
 */

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * 你也可以不继承 AbstractElasticsearchConfiguration 类，而将 ESConfig 写成一般的配置类的型式。
 * 不过继承 AbstractElasticsearchConfiguration 好处在于，它已经帮我们配置好了 elasticsearchTemplate 直接使用。
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.registerservice.outlet.dao.es")
public class ESConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
