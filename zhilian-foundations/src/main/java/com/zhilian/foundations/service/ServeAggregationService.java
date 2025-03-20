package com.zhilian.foundations.service;

import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import com.zhilian.foundations.model.dto.response.ServeSimpleResDTO;

import java.util.List;

public interface ServeAggregationService {

    /**
     * 查询服务列表
     *
     * @param cityCode    城市编码
     * @param serveTypeId 服务类型id
     * @param keyword     关键词
     * @return 服务列表
     */
    List<ServeSimpleResDTO> findServeList(String cityCode, Long serveTypeId, String keyword);

    /**
     * 根据id查询服务聚合
     *
     * @param id 服务聚合id
     * @return 服务聚合
     */
    ServeAggregationResDTO findById(Long id);
}