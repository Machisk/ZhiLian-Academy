package com.zhilian.orders.base.config;

import cn.hutool.core.util.*;
import com.zhilian.common.utils.CollUtils;
import com.zhilian.common.utils.ObjectUtils;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.base.service.IHistoryOrdersSyncCommonService;
import com.zhilian.redis.helper.CacheHelper;
import com.zhilian.statemachine.AbstractStateMachine;
import com.zhilian.statemachine.persist.StateMachinePersister;
import com.zhilian.statemachine.snapshot.BizSnapshotService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.zhilian.orders.base.constants.RedisConstants.RedisKey.ORDERS;

/**
 * 订单状态机
 *
 **/
@Component
public class OrderStateMachine extends AbstractStateMachine<OrderSnapshotDTO> {

    @Resource
    private CacheHelper cacheHelper;

    @Resource
    private IHistoryOrdersSyncCommonService historyOrdersSyncService;

    public OrderStateMachine(StateMachinePersister stateMachinePersister, BizSnapshotService bizSnapshotService, RedisTemplate redisTemplate) {
        super(stateMachinePersister, bizSnapshotService, redisTemplate);
    }

    /**
     * 设置状态机名称
     *
     * @return 状态机名称
     */
    @Override
    protected String getName() {
        return "order";
    }

    @Override
    protected void postProcessor(OrderSnapshotDTO orderSnapshotDTO) {

        /***********************删除用户查询订单的缓存*************************/
        //取出下单用户的id
        Long userId = orderSnapshotDTO.getUserId();

        if(ObjectUtil.isNotNull(userId) && ObjectUtil.isNotNull(orderSnapshotDTO)){
            //清除用户查询订单的的缓存
            String key = String.format(ORDERS, userId);
            if(ObjectUtil.equals(orderSnapshotDTO.getOrdersStatus(), OrderStatusEnum.NO_PAY.getStatus())){
                //删除该用户的缓存
                cacheHelper.remove(key);
            }else{
                //取出订单id
                Long orderId = ObjectUtils.get(orderSnapshotDTO, OrderSnapshotDTO::getId);
                if(ObjectUtil.isNotNull(orderId)){
                    //删除该订单的缓存
                    cacheHelper.remove(key,orderId);
                }
            }
        }
        /***************************完成、关闭、取消订单写历史订单同步表*******************************/
        //取出订单的新状态
        Integer ordersStatus = orderSnapshotDTO.getOrdersStatus();
        if(OrderStatusEnum.FINISHED.getStatus().equals(ordersStatus) ||
                OrderStatusEnum.CLOSED.getStatus().equals(ordersStatus) ||
                   OrderStatusEnum.CANCELED.getStatus().equals(ordersStatus) ){
            historyOrdersSyncService.writeHistorySync(orderSnapshotDTO.getId());
        }

    }

    /**
     * 设置状态机初始状态
     *
     * @return 状态机初始状态
     */
    @Override
    protected OrderStatusEnum getInitState() {
        return OrderStatusEnum.NO_PAY;
    }

}
