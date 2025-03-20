package com.zhilian.api.market;

import com.zhilian.api.market.dto.request.CouponUseReqDTO;
import com.zhilian.api.market.dto.response.AvailableCouponsResDTO;
import com.zhilian.api.market.dto.response.CouponUseResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author MachiskComic
 * @ClassName CouponApi
 * @date 2025-03-20 11:56
 */
@FeignClient(contextId = "jzo2o-market", value = "jzo2o-market", path = "/market/inner/coupon")
public interface CouponApi {

    /**
     * 获取可用优惠券列表，并按照优惠金额从大到小排序
     *
     * @param totalAmount 总金额，单位分
     */
    @GetMapping("/getAvailable")
    List<AvailableCouponsResDTO> getAvailable(@RequestParam("totalAmount") BigDecimal totalAmount);

    /**
     * 优惠券使用,并返回优惠金额
     * @param couponUseReqDTO
     */
    @PostMapping("/use")
    CouponUseResDTO use(@RequestBody CouponUseReqDTO couponUseReqDTO);
}