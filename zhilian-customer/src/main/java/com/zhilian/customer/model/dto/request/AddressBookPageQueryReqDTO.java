package com.zhilian.customer.model.dto.request;

import com.zhilian.common.model.dto.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 地址薄分页查询请求
 * </p>
 *
 */
@Data
@ApiModel("地址薄分页查询请求")
public class AddressBookPageQueryReqDTO extends PageQueryDTO {
}
