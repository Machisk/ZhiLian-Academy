package com.zhilian.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.customer.model.domain.ServeProvider;
import com.zhilian.customer.model.dto.request.ServeProviderPageQueryReqDTO;
import com.zhilian.customer.model.dto.response.ServeProviderBasicInformationResDTO;
import com.zhilian.customer.model.dto.response.ServeProviderListResDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务人员/机构表 Mapper 接口
 * </p>
 *
 */
public interface ServeProviderMapper extends BaseMapper<ServeProvider> {

    /**
     * 分页查询服务人员
     *
     * @param serveProviderPageQueryReqDTO 分页查询请求体
     * @return 服务人员列表
     */
    List<ServeProviderListResDTO> queryWorkerList(ServeProviderPageQueryReqDTO serveProviderPageQueryReqDTO);


    /**
     * 分页查询机构
     *
     * @param serveProviderPageQueryReqDTO 分页查询请求体
     * @return 机构列表
     */
    List<ServeProviderListResDTO> queryAgencyList(ServeProviderPageQueryReqDTO serveProviderPageQueryReqDTO);

    /**
     * 根据服务人员/机构id查询基本信息
     *
     * @param id 服务人员/机构id
     * @return 基本信息
     */
    ServeProviderBasicInformationResDTO findBasicInformationById(@Param("id") Long id);
}
