package com.zhilian.api.foundations;

import com.zhilian.api.foundations.dto.response.ServeItemResDTO;
import com.zhilian.api.foundations.dto.response.ServeItemSimpleResDTO;
import com.zhilian.api.foundations.dto.response.ServeTypeCategoryResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 内部接口 - 服务项相关接口
 *
 */
@FeignClient(contextId = "zhilian-foundations", value = "zhilian-foundations", path = "/foundations/inner/serve-item")
public interface ServeItemApi {

    @GetMapping("/{id}")
    ServeItemResDTO findById(@PathVariable("id") Long id);

    @GetMapping("/listByIds")
    List<ServeItemSimpleResDTO> listByIds(@RequestParam("ids") List<Long> ids);

    /**
     * 查询启用状态的服务项目录
     *
     * @return 服务项目录
     */
    @GetMapping("/queryActiveServeItemCategory")
    List<ServeTypeCategoryResDTO> queryActiveServeItemCategory();
}
