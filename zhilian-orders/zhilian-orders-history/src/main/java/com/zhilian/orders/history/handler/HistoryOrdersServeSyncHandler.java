package com.zhilian.orders.history.handler;

import com.zhilian.canal.listeners.AbstractCanalRabbitMqMsgListener;
import com.zhilian.orders.history.model.domain.HistoryOrders;
import com.zhilian.orders.history.model.domain.HistoryOrdersServe;
import com.zhilian.orders.history.model.domain.HistoryOrdersServeSync;
import com.zhilian.orders.history.service.IHistoryOrdersServeService;
import com.zhilian.orders.history.service.IHistoryOrdersServeSyncService;
import com.zhilian.orders.history.service.IHistoryOrdersService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HistoryOrdersServeSyncHandler extends AbstractCanalRabbitMqMsgListener<HistoryOrdersServeSync> {

    @Resource
    private IHistoryOrdersServeSyncService historyOrdersServeSyncService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "canal-mq-zhilian-orders-serve-history",durable = "true"),
            exchange = @Exchange(name = "exchange.canal-zhilian", type = ExchangeTypes.TOPIC),
            key = "canal-mq-zhilian-orders-serve-history"),
            concurrency = "1"
    )
    public void onMessage(Message message) throws Exception {
        parseMsg(message);
    }

    @Override
    public void batchSave(List<HistoryOrdersServeSync> historyOrdersServeSyncs) {
        historyOrdersServeSyncService.saveOrUpdateBatch(historyOrdersServeSyncs);
    }

    @Override
    public void batchDelete(List<Long> ids) {

    }
}
