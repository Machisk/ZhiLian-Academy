package com.zhilian.customer.model.dto.request;

import com.zhilian.common.model.dto.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 服务人员/机构分页查询请求
 * </p>
 *
 */
@Data
@ApiModel("服务人员/机构分页查询请求")
public class ServeProviderPageQueryReqDTO extends PageQueryDTO {

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 是否可以接单，0：关闭接单，1：开启接单
     */
    @ApiModelProperty("是否可以接单，0：关闭接单，1：开启接单")
    private Integer canPickUp;

    /**
     * 状态，0：正常，1：冻结
     */
    @ApiModelProperty("状态，0：正常，1：冻结")
    private Integer status;
}
