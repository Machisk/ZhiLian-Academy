package com.zhilian.foundations.controller.inner;

import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import com.zhilian.foundations.service.ServeAggregationService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MachiskComic
 * @ClassName InnerServeController
 * @date 2025-03-20 21:25
 */
@RestController
@RequestMapping("/inner/serve")
@Api(tags = "内部接口 - 服务相关接口")
public class InnerServeController {

    @Resource
    private ServeAggregationService serveAggregationService;

    @GetMapping("/{id}")
    ServeAggregationResDTO findById(@PathVariable("id") Long id) {
        return serveAggregationService.findById(id);
    }
}
