package com.zhilian.orders.history.handler;

import com.zhilian.canal.listeners.AbstractCanalRabbitMqMsgListener;
import com.zhilian.orders.history.model.domain.HistoryOrdersSync;
import com.zhilian.orders.history.service.IHistoryOrdersSyncService;
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
public class HistoryOrdersSyncHandler extends AbstractCanalRabbitMqMsgListener<HistoryOrdersSync> {

    @Resource
    private IHistoryOrdersSyncService historyOrdersSyncService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "canal-mq-zhilian-orders-history", durable = "true"),
            exchange = @Exchange(name = "exchange.canal-zhilian", type = ExchangeTypes.TOPIC),
            key = "canal-mq-zhilian-orders-history"),
            concurrency = "1"
    )
    public void onMessage(Message message) throws Exception {
        parseMsg(message);
    }

    @Override
    public void batchSave(List<HistoryOrdersSync> historyOrdersSyncs) {
        historyOrdersSyncService.saveOrUpdateBatch(historyOrdersSyncs);
    }

    @Override
    public void batchDelete(List<Long> ids) {

    }
}
