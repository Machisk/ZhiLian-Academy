package com.zhilian.orders.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.orders.base.enums.BreachHaviorTypeEnum;
import com.zhilian.orders.base.model.domain.BreachRecord;

/**
 * <p>
 * 违约记录 服务类
 * </p>
 *
 */
public interface IBreachRecordService extends IService<BreachRecord> {


    /**
     * 单独添加违约记录
     *
     * @param breachRecord 违约信息
     */
    void add(BreachRecord breachRecord);


    /**
     * 统计违约记录
     * @param serveProviderId 服务人员或机构id
     * @param breachHaviorTypeEnum 拒单类型
     * @return
     */
    int count(Long serveProviderId, BreachHaviorTypeEnum breachHaviorTypeEnum, int breachDay);

}
