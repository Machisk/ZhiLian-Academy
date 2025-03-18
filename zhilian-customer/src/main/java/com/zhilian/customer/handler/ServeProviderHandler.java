package com.zhilian.customer.handler;

import com.zhilian.canal.listeners.AbstractCanalRabbitMqMsgListener;
import com.zhilian.common.expcetions.BadRequestException;
import com.zhilian.common.expcetions.CommonException;
import com.zhilian.common.model.Location;
import com.zhilian.common.utils.BeanUtils;
import com.zhilian.common.utils.CollUtils;
import com.zhilian.customer.constants.EsIndexConstants;
import com.zhilian.customer.model.domain.ServeProviderInfo;
import com.zhilian.customer.model.domain.ServeProviderSync;
import com.zhilian.es.core.ElasticSearchTemplate;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Data
@Component
@Slf4j
public class ServeProviderHandler extends AbstractCanalRabbitMqMsgListener<ServeProviderSync> {
    @Resource
    private ElasticSearchTemplate elasticSearchTemplate;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "canal-mq-zhilian-customer-provider"),
            exchange = @Exchange(name = "exchange.canal-zhilian", type = ExchangeTypes.TOPIC),
            key = "canal-mq-zhilian-customer-provider"),
            concurrency = "1"
    )
    public void onMessage(Message message) throws Exception {
        parseMsg(message);
    }

    @Override
    public void batchSave(List<ServeProviderSync> data) {
        List<ServeProviderInfo> serveProviderInfos = BeanUtils.copyToList(data, ServeProviderInfo.class, (sync, info) -> {
            info.setLocation(new Location(sync.getLon(), sync.getLat()));
        });
        log.debug("serveProviderInfos : {}", serveProviderInfos);

        if(!elasticSearchTemplate.opsForDoc().batchUpsert(EsIndexConstants.SERVE_PROVIDER_INFO, serveProviderInfos)){
            throw new CommonException("服务人员或机构信息同步异常");
        }
    }

    @Override
    public void batchDelete(List<Long> ids) {
        elasticSearchTemplate.opsForDoc().batchDelete(EsIndexConstants.SERVE_PROVIDER_INFO, ids);
    }
}
