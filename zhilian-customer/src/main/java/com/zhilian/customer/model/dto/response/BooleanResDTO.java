package com.zhilian.customer.model.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 布尔值响应
 *
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("布尔值响应")
public class BooleanResDTO {

    /**
     * 是否成功
     */
    @ApiModelProperty("是否成功")
    private Boolean isSuccess = false;
}
