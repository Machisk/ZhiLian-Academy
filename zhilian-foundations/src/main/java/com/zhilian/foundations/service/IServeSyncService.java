package com.zhilian.foundations.service;

import com.zhilian.foundations.model.domain.ServeSync;
import com.zhilian.foundations.model.dto.request.ServeSyncUpdateReqDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务同步表 服务类
 * </p>
 *
 */
public interface IServeSyncService extends IService<ServeSync> {
    /**
     * 根据服务项id更新
     *
     * @param serveItemId           服务项id
     * @param serveSyncUpdateReqDTO 服务同步更新数据
     */
    void updateByServeItemId(Long serveItemId, ServeSyncUpdateReqDTO serveSyncUpdateReqDTO);

    /**
     * 根据服务类型id更新
     *
     * @param serveTypeId           服务类型id
     * @param serveSyncUpdateReqDTO 服务同步更新数据
     */
    void updateByServeTypeId(Long serveTypeId, ServeSyncUpdateReqDTO serveSyncUpdateReqDTO);
}
