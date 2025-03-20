package com.zhilian.api.orders.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务人员/机构id
 *
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServeProviderIdResDTO {

    /**
     * 服务人员/机构id
     */
    private Long serveProviderId;
}
