package com.zhilian.orders.manager.model.dto.request;

import com.zhilian.api.trade.enums.PayChannelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 订单支付请求体
 *
 **/
@Data
@ApiModel("订单支付请求体")
public class OrdersPayReqDTO {
    @ApiModelProperty(value = "支付渠道", required = true)
    @NotNull(message = "支付渠道不能为空")
    private PayChannelEnum tradingChannel;
}
