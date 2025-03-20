package com.zhilian.foundations.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import com.zhilian.common.expcetions.ElasticSearchException;
import com.zhilian.common.utils.BeanUtils;
import com.zhilian.common.utils.LambdaUtils;
import com.zhilian.es.core.ElasticSearchTemplate;
import com.zhilian.es.utils.SearchResponseUtils;
import com.zhilian.foundations.constants.IndexConstants;
import com.zhilian.foundations.model.domain.ServeAggregation;
import com.zhilian.foundations.model.dto.response.ServeSimpleResDTO;
import com.zhilian.foundations.service.ServeAggregationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 服务相关
 *
 **/
@Slf4j
@Service
public class ServeAggregationServiceImpl implements ServeAggregationService {

    @Resource
    private ElasticSearchTemplate elasticSearchTemplate;


    /**
     * 查询服务列表
     *
     * @param cityCode    城市编码
     * @param serveTypeId 服务类型id
     * @param keyword     关键词
     * @return 服务列表
     */
    @Override
    public List<ServeSimpleResDTO> findServeList(String cityCode, Long serveTypeId, String keyword) {
        // 构造查询条件
        SearchRequest.Builder builder = new SearchRequest.Builder();

        builder.query(query->query.bool(bool->{
            //匹配citycode
            bool.must(must->
                    must.term(term->
                            term.field("city_code").value(cityCode)));
            //todo匹配服务类型
            if(ObjectUtils.isNotEmpty(serveTypeId)){
                bool.must(must->
                        must.term(term->
                                term.field("serve_type_id").value(serveTypeId)));
            }
            //匹配关键字
            if(ObjectUtils.isNotEmpty(keyword)){
                bool.must(must->
                    must.multiMatch(multiMatch->
                        multiMatch.fields("serve_item_name","serve_type_name").query(keyword)));
            }
            return bool;
        }));
        // 排序 按服务项的serveItemSortNum排序(升序)
        List<SortOptions> sortOptions = new ArrayList<>();
        sortOptions.add(SortOptions.of(sortOption -> sortOption.field(field->field.field("serve_item_sort_num").order(SortOrder.Asc))));
        builder.sort(sortOptions);
        //指定索引
        builder.index("serve_aggregation");
        //请求对象
        SearchRequest searchRequest = builder.build();
        // 检索数据
        SearchResponse<ServeAggregation> searchResponse = elasticSearchTemplate.opsForDoc().search(searchRequest, ServeAggregation.class);
        //如果搜索成功返回结果集
        if (SearchResponseUtils.isSuccess(searchResponse)) {
            List<ServeAggregation> collect = searchResponse.hits().hits()
                    .stream().map(hit -> {
                        ServeAggregation serve = hit.source();
                        return serve;
                    })
                    .collect(Collectors.toList());
            List<ServeSimpleResDTO> serveSimpleResDTOS = BeanUtil.copyToList(collect, ServeSimpleResDTO.class);
            return serveSimpleResDTOS;
        }
        return  Collections.emptyList();

    }

    @Override
    public ServeAggregationResDTO findById(Long id) {
        //根据id查询服务有关信息
        ServeAggregation serveAggregation = elasticSearchTemplate.opsForDoc().findById(IndexConstants.SERVE, id, ServeAggregation.class);
        //如果搜索成功返回结果
        if (com.zhilian.common.utils.ObjectUtils.isNotEmpty(serveAggregation)) {
            return BeanUtils.copyProperties(serveAggregation, ServeAggregationResDTO.class);
        }
        return null;
    }

}