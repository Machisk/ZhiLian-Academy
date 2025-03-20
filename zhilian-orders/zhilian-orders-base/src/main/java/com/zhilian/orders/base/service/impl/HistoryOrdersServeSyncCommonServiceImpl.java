package com.zhilian.orders.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.api.customer.InstitutionStaffApi;
import com.zhilian.api.customer.ServeProviderApi;
import com.zhilian.api.orders.OrdersHistoryApi;
import com.zhilian.common.utils.CollUtils;
import com.zhilian.common.utils.DateUtils;
import com.zhilian.orders.base.mapper.HistoryOrdersServeSyncMapper;
import com.zhilian.orders.base.mapper.OrdersCanceledMapper;
import com.zhilian.orders.base.mapper.OrdersMapper;
import com.zhilian.orders.base.mapper.OrdersServeMapper;
import com.zhilian.orders.base.model.domain.HistoryOrdersServeSync;
import com.zhilian.orders.base.service.IHistoryOrdersServeSyncCommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务任务 服务实现类
 * </p>
 *
 */
@Service
public class HistoryOrdersServeSyncCommonServiceImpl extends ServiceImpl<HistoryOrdersServeSyncMapper, HistoryOrdersServeSync> implements IHistoryOrdersServeSyncCommonService {
}
