package com.zhilian.market.model.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("活动分页字段模型")
public class ActivityInfoResDTO {
    @ApiModelProperty("活动id")
    private Long id;
    @ApiModelProperty("活动名称")
    private String name;
    @ApiModelProperty("优惠券类型，1：满减，2：折扣")
    private Integer type;
    @ApiModelProperty("满减限额，0：表示无门槛，其他值：最低消费金额")
    private BigDecimal amountCondition;
    @ApiModelProperty("折扣率，折扣类型的折扣率，例如：8,打8折")
    private Integer discountRate;
    @ApiModelProperty("优惠金额，满减或无门槛的优惠金额")
    private BigDecimal discountAmount;
    @ApiModelProperty("发放开始时间")
    private LocalDateTime distributeStartTime;
    @ApiModelProperty("发放结束时间")
    private LocalDateTime distributeEndTime;
    @ApiModelProperty("优惠券配置状态，1：待生效，2：进行中，3：已失效")
    private Integer status;
    @ApiModelProperty("发放数量，0：表示无限量，其他正数表示最大发放量")
    private Integer totalNum;
    @ApiModelProperty("领取数量")
    private Integer receiveNum;
    @ApiModelProperty("核销数量")
    private Integer writeOffNum;
    @ApiModelProperty("有效期天数")
    private Integer validityDays;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
