package com.zhilian.foundations.controller.operation;


import com.zhilian.api.foundations.dto.response.ServeItemResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.foundations.model.dto.request.ServeItemPageQueryReqDTO;
import com.zhilian.foundations.model.dto.request.ServeItemUpsertReqDTO;
import com.zhilian.foundations.service.IServeItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 服务表 前端控制器
 * </p>
 *
 */
@Validated
@RestController("operationServeItemController")
@RequestMapping("/operation/serve-item")
@Api(tags = "运营端 - 服务项相关接口")
public class ServeItemController {
    @Resource
    private IServeItemService serveItemService;

    @PostMapping
    @ApiOperation("服务项新增")
    public void add(@RequestBody ServeItemUpsertReqDTO serveItemUpsertReqDTO) {
        serveItemService.add(serveItemUpsertReqDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation("服务项修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务项id", required = true, dataTypeClass = Long.class)
    })
    public void update(@NotNull(message = "id不能为空") @PathVariable("id") Long id, @RequestBody ServeItemUpsertReqDTO serveItemUpsertReqDTO) {
        serveItemService.update(id, serveItemUpsertReqDTO);
    }


    @PutMapping("/activate/{id}")    //启用状态，1：禁用，:2：启用
    @ApiOperation("服务项启用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class),
    })
    public void activate(@PathVariable("id") Long id) {
        serveItemService.activate(id);
    }

    @PutMapping("/deactivate/{id}")
    @ApiOperation("服务项禁用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class),
    })
    public void deactivate(@PathVariable("id") Long id) {
        serveItemService.deactivate(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("服务项删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务项id", required = true, dataTypeClass = Long.class),
    })
    public void delete(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        serveItemService.deleteById(id);
    }

    @GetMapping("/page")
    @ApiOperation("服务项分页查询")
    public PageResult<ServeItemResDTO> page(ServeItemPageQueryReqDTO serveItemPageQueryReqDTO) {
        return serveItemService.page(serveItemPageQueryReqDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询服务项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务项id", required = true, dataTypeClass = Long.class)
    })
    public ServeItemResDTO findById(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        return serveItemService.queryServeItemAndTypeById(id);
    }
}
