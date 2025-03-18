package com.zhilian.api.customer;

import com.zhilian.api.customer.dto.InstitutionUserPageQueryDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.api.customer.dto.InstitutionUserPageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 机构相关列表
 */
@FeignClient(contextId = "zhilian-customer", value = "zhilian-customer", path = "/customer/inner/institutions/user")
public interface InstitutionApi {

    /**
     * 分页查询机构用户信息
     *
     * @param institutionUserPageQueryDTO 查询条件
     * @return
     */
    @GetMapping("")
    PageResult<InstitutionUserPageDTO> queryForAdmin(@SpringQueryMap InstitutionUserPageQueryDTO institutionUserPageQueryDTO);
}
