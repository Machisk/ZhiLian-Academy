package com.zhilian.api.customer.dto;

import com.zhilian.common.model.dto.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("机构用户查询条件模型")
public class InstitutionUserPageQueryDTO extends PageQueryDTO {
    private String name;
    private String phone;
    private Integer status;
}
