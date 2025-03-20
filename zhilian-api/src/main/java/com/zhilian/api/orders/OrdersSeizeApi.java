package com.zhilian.api.orders;

import com.zhilian.api.orders.dto.request.OrderSeizeReqDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-orders-seize", value = "zhilian-orders-seize", path = "/orders-seize/inner/seize")
public interface OrdersSeizeApi {

    /**
     * 机器抢单
     *
     * @param orderSeizeReqDTO
     */
    @PostMapping("")
    void machineSeize(@RequestBody OrderSeizeReqDTO orderSeizeReqDTO);

}
