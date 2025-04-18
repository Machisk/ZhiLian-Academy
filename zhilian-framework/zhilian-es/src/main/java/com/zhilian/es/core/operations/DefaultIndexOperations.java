package com.zhilian.es.core.operations;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultIndexOperations implements IndexOperations{
    private final ElasticsearchClient elasticsearchClient;

    public DefaultIndexOperations(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }
}
