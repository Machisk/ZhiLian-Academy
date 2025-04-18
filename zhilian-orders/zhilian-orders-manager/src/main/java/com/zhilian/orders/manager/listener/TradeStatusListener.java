package com.zhilian.orders.manager.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.zhilian.api.trade.enums.TradingStateEnum;
import com.zhilian.common.constants.MqConstants;
import com.zhilian.common.model.msg.TradeStatusMsg;
import com.zhilian.orders.manager.service.IOrdersCreateService;
import com.zhilian.orders.manager.service.IOrdersManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.zhilian.orders.base.constants.OrderConstants.PRODUCT_APP_ID;

/**
 * 监听mq消息，接收支付结果
 *
 **/
@Slf4j
@Component
public class TradeStatusListener {
    @Resource
    private IOrdersCreateService ordersCreateService;

    /**
     * 更新支付结果
     * 支付成功
     *
     * @param msg 消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = MqConstants.Queues.ORDERS_TRADE_UPDATE_STATUS),
            exchange = @Exchange(name = MqConstants.Exchanges.TRADE, type = ExchangeTypes.TOPIC),
            key = MqConstants.RoutingKeys.TRADE_UPDATE_STATUS
    ))
    public void listenTradeUpdatePayStatusMsg(String msg) {
        log.info("接收到支付结果状态的消息 ({})-> {}", MqConstants.Queues.ORDERS_TRADE_UPDATE_STATUS, msg);
        List<TradeStatusMsg> tradeStatusMsgList = JSONUtil.toBean(msg, new TypeReference<List<TradeStatusMsg>>() {
        }, false);

        // 只处理智联学堂的订单且是支付成功的
        List<TradeStatusMsg> msgList = tradeStatusMsgList.stream().filter(v -> v.getStatusCode().equals(TradingStateEnum.YJS.getCode()) && PRODUCT_APP_ID.equals(v.getProductAppId())).collect(Collectors.toList());
        if (CollUtil.isEmpty(msgList)) {
            return;
        }

        //修改订单状态
        msgList.forEach(m -> ordersCreateService.paySuccess(m));
    }
}
