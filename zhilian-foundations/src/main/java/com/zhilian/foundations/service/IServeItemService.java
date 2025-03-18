package com.zhilian.foundations.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.api.foundations.dto.response.ServeItemResDTO;
import com.zhilian.api.foundations.dto.response.ServeItemSimpleResDTO;
import com.zhilian.api.foundations.dto.response.ServeTypeCategoryResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.foundations.model.domain.ServeItem;
import com.zhilian.foundations.model.dto.request.ServeItemPageQueryReqDTO;
import com.zhilian.foundations.model.dto.request.ServeItemUpsertReqDTO;

import java.util.List;

/**
 * <p>
 * 服务表 服务类
 * </p>
 *
 */
public interface IServeItemService extends IService<ServeItem> {
    /**
     * 服务项新增
     *
     * @param serveItemUpsertReqDTO 插入更新服务项
     */
    void add(ServeItemUpsertReqDTO serveItemUpsertReqDTO);

    /**
     * 服务项修改
     *
     * @param id                    服务项id
     * @param serveItemUpsertReqDTO 插入更新服务项
     * @return 服务项
     */
    ServeItem update(Long id, ServeItemUpsertReqDTO serveItemUpsertReqDTO);

    /**
     * 启用服务项
     *
     * @param id 服务项id
     * @return
     */
    ServeItem activate(Long id);

    /**
     * 禁用服务项
     *
     * @param id 服务项id
     * @return
     */
    void deactivate(Long id);

    /**
     * 服务项删除
     *
     * @param id 服务项id
     */
    void deleteById(Long id);

    /**
     * 根据服务类型id查询关联的启用状态服务项数量
     *
     * @param serveTypeId 服务类型id
     * @return 服务项数量
     */
    int queryActiveServeItemCountByServeTypeId(Long serveTypeId);

    /**
     * 分页查询
     *
     * @param serveItemPageQueryReqDTO 查询条件
     * @return 分页结果
     */
    PageResult<ServeItemResDTO> page(ServeItemPageQueryReqDTO serveItemPageQueryReqDTO);

    /**
     * 根据id查询详情
     *
     * @param id 服务项id
     * @return 服务项详细信息
     */
    ServeItemResDTO queryServeItemAndTypeById(Long id);

    /**
     * 根据id列表批量查询
     *
     * @param ids 服务项id列表
     * @return 服务项简略列表
     */
    List<ServeItemSimpleResDTO> queryServeItemListByIds(List<Long> ids);

    /**
     * 查询启用状态的服务项目录
     *
     * @return 服务项目录
     */
    List<ServeTypeCategoryResDTO> queryActiveServeItemCategory();
}
