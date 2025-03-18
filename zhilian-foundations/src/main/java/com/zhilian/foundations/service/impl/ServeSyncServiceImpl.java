package com.zhilian.foundations.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.foundations.mapper.ServeSyncMapper;
import com.zhilian.foundations.model.domain.ServeSync;
import com.zhilian.foundations.model.dto.request.ServeSyncUpdateReqDTO;
import com.zhilian.foundations.service.IServeSyncService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务同步表 服务实现类
 * </p>
 *
 */
@Service
public class ServeSyncServiceImpl extends ServiceImpl<ServeSyncMapper, ServeSync> implements IServeSyncService {
    /**
     * 根据服务项id更新
     *
     * @param serveItemId           服务项id
     * @param serveSyncUpdateReqDTO 服务同步更新数据
     */
    @Override
    public void updateByServeItemId(Long serveItemId, ServeSyncUpdateReqDTO serveSyncUpdateReqDTO) {
        LambdaUpdateWrapper<ServeSync> updateWrapper = Wrappers.<ServeSync>lambdaUpdate()
                .eq(ServeSync::getServeItemId, serveItemId)
                .set(ServeSync::getServeItemName, serveSyncUpdateReqDTO.getServeItemName())
                .set(ServeSync::getServeItemSortNum, serveSyncUpdateReqDTO.getServeItemSortNum())
                .set(ServeSync::getUnit, serveSyncUpdateReqDTO.getUnit())
                .set(ServeSync::getServeItemImg, serveSyncUpdateReqDTO.getServeItemImg())
                .set(ServeSync::getServeItemIcon, serveSyncUpdateReqDTO.getServeItemIcon());
        super.update(updateWrapper);
    }

    /**
     * 根据服务类型id更新
     *
     * @param serveTypeId           服务类型id
     * @param serveSyncUpdateReqDTO 服务同步更新数据
     */
    @Override
    public void updateByServeTypeId(Long serveTypeId, ServeSyncUpdateReqDTO serveSyncUpdateReqDTO) {
        LambdaUpdateWrapper<ServeSync> updateWrapper = Wrappers.<ServeSync>lambdaUpdate()
                .eq(ServeSync::getServeTypeId, serveTypeId)
                .set(ServeSync::getServeTypeName, serveSyncUpdateReqDTO.getServeTypeName())
                .set(ServeSync::getServeTypeImg, serveSyncUpdateReqDTO.getServeTypeImg())
                .set(ServeSync::getServeTypeIcon, serveSyncUpdateReqDTO.getServeTypeIcon())
                .set(ServeSync::getServeTypeSortNum, serveSyncUpdateReqDTO.getServeTypeSortNum());
        super.update(updateWrapper);
    }
}
