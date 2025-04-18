package com.zhilian.orders.dispatch.model.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel("接单模型")
@Data
public class DispatchReceiveReqDTO {
    @ApiModelProperty(value = "派单id",required = true)
    @NotNull(message = "接单id")
    private Long id;
}
