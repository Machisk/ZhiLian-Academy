package com.zhilian.api.foundations;

import com.zhilian.api.foundations.dto.response.ServeTypeSimpleResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 内部接口 - 服务类型相关接口
 *
 */
@FeignClient(contextId = "zhilian-foundations", value = "zhilian-foundations", path = "/foundations/inner/serve-type")
public interface ServeTypeApi {

    @GetMapping("/listByIds")
    List<ServeTypeSimpleResDTO> listByIds(@RequestParam("ids") List<Long> ids);
}
