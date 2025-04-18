package com.zhilian.customer.model.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 机构下属服务人员简略响应数据
 *
 **/
@Data
@ApiModel("机构下属服务人员简略响应数据")
public class InstitutionStaffSimpleResDTO {
    /**
     * 服务人员id
     */
    @ApiModelProperty("服务人员id")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;
}
