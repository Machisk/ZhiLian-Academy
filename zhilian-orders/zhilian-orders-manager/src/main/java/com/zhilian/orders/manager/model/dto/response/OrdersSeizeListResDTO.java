package com.zhilian.orders.manager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel("抢单列表")
@NoArgsConstructor
@AllArgsConstructor
public class OrdersSeizeListResDTO implements Serializable {

    @ApiModelProperty("抢单列表")
    private List<OrdersSeize> ordersSeizes;

    @Data
    public static class OrdersSeize implements Serializable{
        /**
         * 订单id
         */
        @ApiModelProperty(value = "订单id",required = true)
        private Long id;

        /**
         * 服务名称
         */
        @ApiModelProperty(value = "服务项名称",required = true)
        private String serveItemName;

        @ApiModelProperty(value = "服务分类id",required = true)
        private Long serveTypeId;

        /**
         * 服务分类名称
         */
        @ApiModelProperty(value = "服务类型名称",required = true)
        private String serveTypeName;

        /**
         * 服务地址
         */
        @ApiModelProperty(value = "服务地址",required = true)
        private String serveAddress;

        /**
         * 服务项目图片
         */
        @ApiModelProperty(value = "服务图片",required = true)
        private String serveItemImg;

        /**
         * 收益
         */
        @ApiModelProperty(value = "服务费",required = true)
        private BigDecimal serveFee;

        /**
         * 服务开始时间
         */
        @ApiModelProperty(value = "服务开始时间",required = true)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime serveStartTime;

        /**
         * 开始派单时间
         */
        @ApiModelProperty(value = "服务开始派单时间",required = true)
        private LocalDateTime startDispatchTime;


        /**
         * 服务数量
         */
        @ApiModelProperty(value = "服务数量",required = true)
        private Integer purNum;

    }
}
