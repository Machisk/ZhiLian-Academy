package com.zhilian.orders.manager.model.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("服务完成模型")
public class ServeStartReqDTO {
    @ApiModelProperty("服务开始id")
    private Long id;

    @ApiModelProperty("服务图片")
    private List<String> serveBeforeImgs;

    @ApiModelProperty("服务前说明")
    private String serveBeforeIllustrate;
}
