package com.zhilian.customer.controller.inner;

import cn.hutool.core.bean.BeanUtil;
import com.zhilian.api.customer.dto.response.AddressBookResDTO;
import com.zhilian.customer.model.domain.AddressBook;
import com.zhilian.customer.service.IAddressBookService;
import com.zhilian.api.customer.AddressBookApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MachiskComic
 * @ClassName InnerAddressBookController
 * @date 2025-03-20 12:04
 */
@RestController
@RequestMapping("inner/address-book")
@Api(tags = "内部接口 - 地址薄相关接口")
public class InnerAddressBookController implements AddressBookApi {
    @Resource
    private IAddressBookService addressBookService;

    @GetMapping("/{id}")
    @ApiOperation("地址薄详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址薄id", required = true, dataTypeClass = Long.class)
    })
    public AddressBookResDTO detail(@PathVariable("id") Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        return BeanUtil.toBean(addressBook, AddressBookResDTO.class);
    }

}