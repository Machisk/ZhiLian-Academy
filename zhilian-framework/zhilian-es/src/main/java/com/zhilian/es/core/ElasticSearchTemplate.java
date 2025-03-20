package com.zhilian.es.core;

import com.zhilian.es.core.operations.DocumentOperations;
import com.zhilian.es.core.operations.IndexOperations;

public interface ElasticSearchTemplate {
    DocumentOperations opsForDoc();
    IndexOperations opsForIndex();
}
