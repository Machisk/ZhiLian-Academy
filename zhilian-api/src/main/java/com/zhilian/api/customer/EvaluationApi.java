package com.zhilian.api.customer;

import com.zhilian.api.customer.dto.request.EvaluationSubmitReqDTO;
import com.zhilian.api.customer.dto.response.EvaluationScoreResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "zhilian-customer", value = "zhilian-customer", path = "/customer/inner/evaluation")
public interface EvaluationApi {

    /**
     * 根据订单id列表查询师傅评分
     *
     * @param orderIds 订单id列表
     * @return 评分
     */
    @GetMapping("/queryServeProviderScoreByOrdersId")
    EvaluationScoreResDTO queryServeProviderScoreByOrdersId(@RequestParam("orderIds") List<Long> orderIds);

    /**
     * 自动评价
     *
     * @param evaluationSubmitReqDTO 评价信息
     */
    @PostMapping("/autoEvaluate")
    void autoEvaluate(@RequestBody EvaluationSubmitReqDTO evaluationSubmitReqDTO);
}
