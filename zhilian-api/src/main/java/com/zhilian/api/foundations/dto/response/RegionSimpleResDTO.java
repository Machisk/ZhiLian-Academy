package com.zhilian.api.foundations.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 区域简略响应值
 *
 **/
@Data
@ApiModel("区域简略响应值")
public class RegionSimpleResDTO {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 区域名称
     */
    @ApiModelProperty("区域名称")
    private String name;

    /**
     * 城市编码
     */
    @ApiModelProperty("城市编码")
    private String cityCode;
}
