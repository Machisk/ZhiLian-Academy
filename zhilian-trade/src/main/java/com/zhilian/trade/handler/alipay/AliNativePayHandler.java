package com.zhilian.trade.handler.alipay;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONUtil;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.zhilian.common.constants.ErrorInfo;
import com.zhilian.common.expcetions.CommonException;
import com.zhilian.trade.annotation.PayChannel;
import com.zhilian.api.trade.enums.PayChannelEnum;
import com.zhilian.trade.enums.TradingEnum;
import com.zhilian.trade.enums.TradingStateEnum;
import com.zhilian.trade.handler.NativePayHandler;
import com.zhilian.trade.model.domain.Trading;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 支付宝的扫描支付的具体实现
 */
@Slf4j
@Component("aliNativePayHandler")
@PayChannel(type = PayChannelEnum.ALI_PAY)
public class AliNativePayHandler implements NativePayHandler {

    @Override
    public void createDownLineTrading(Trading tradingEntity) throws CommonException {
        //查询配置
        Config config = AlipayConfig.getConfig(tradingEntity.getEnterpriseId());
        //Factory使用配置
        Factory.setOptions(config);
        AlipayTradePrecreateResponse response;
        try {
            //调用支付宝API面对面支付
            response = Factory
                    .Payment
                    .FaceToFace()
                    .preCreate(tradingEntity.getMemo(), //订单描述
                            Convert.toStr(tradingEntity.getTradingOrderNo()), //业务订单号
                            Convert.toStr(tradingEntity.getTradingAmount())); //金额
        } catch (Exception e) {
            log.error("支付宝统一下单创建失败：tradingEntity = {}", tradingEntity, e);
            throw new CommonException(ErrorInfo.Code.TRADE_FAILED, TradingEnum.NATIVE_PAY_FAIL.getValue());
        }

        //受理结果【只表示请求是否成功，而不是支付是否成功】
        boolean isSuccess = ResponseChecker.success(response);
        //6.1、受理成功：修改交易单
        if (isSuccess) {
            String subCode = response.getSubCode();
            String subMsg = response.getQrCode();
            tradingEntity.setPlaceOrderCode(subCode); //返回的编码
            tradingEntity.setPlaceOrderMsg(subMsg); //二维码需要展现的信息
            tradingEntity.setPlaceOrderJson(JSONUtil.toJsonStr(response));
            tradingEntity.setTradingState(TradingStateEnum.FKZ);
            return;
        }
        throw new CommonException(ErrorInfo.Code.TRADE_FAILED, TradingEnum.NATIVE_PAY_FAIL.getValue());
    }

}
