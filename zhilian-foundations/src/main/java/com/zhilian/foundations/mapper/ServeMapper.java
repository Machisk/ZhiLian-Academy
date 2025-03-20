package com.zhilian.foundations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import com.zhilian.foundations.model.domain.Serve;
import com.zhilian.foundations.model.dto.response.ServeAggregationSimpleResDTO;
import com.zhilian.foundations.model.dto.response.ServeAggregationTypeSimpleResDTO;
import com.zhilian.foundations.model.dto.response.ServeCategoryResDTO;
import com.zhilian.foundations.model.dto.response.ServeResDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 */
public interface ServeMapper extends BaseMapper<Serve> {
    /**
     * 根据区域查询服务列表
     * @param regionId
     * @return
     */
    List<ServeResDTO> queryServeListByRegionId(@Param("regionId") Long regionId);

    List<ServeCategoryResDTO> findServeIconCategoryByRegionId(Long regionId);

    List<ServeAggregationTypeSimpleResDTO> findServeServeTypeListByRegionId(Long regionId);

    List<ServeAggregationSimpleResDTO> findHotServeListByRegionId(Long regionId);

    ServeAggregationSimpleResDTO queryServeDetailByServeId(Long id);
}
