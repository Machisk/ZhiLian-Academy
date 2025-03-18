package com.zhilian.customer.model.dto.request;

import com.zhilian.common.model.dto.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 机构分页查询请求
 *
 **/
@Data
@ApiModel("机构分页查询请求")
public class AgencyCertificationAuditPageQueryReqDTO extends PageQueryDTO {
    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String name;

    /**
     * 法人姓名
     */
    @ApiModelProperty("法人姓名")
    private String legalPersonName;

    /**
     * 审核状态，0：未审核，1：已审核
     */
    @ApiModelProperty("审核状态，0：未审核，1：已审核")
    private Integer auditStatus;

    /**
     * 认证状态，2：认证通过，3：认证失败
     */
    @ApiModelProperty("认证状态，2：认证通过，3：认证失败")
    private Integer certificationStatus;
}
