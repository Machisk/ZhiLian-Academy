package com.zhilian.customer.controller.operation;

import cn.hutool.core.bean.BeanUtil;
import com.zhilian.customer.model.dto.response.BankAccountResDTO;
import com.zhilian.customer.service.IBankAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("operationBankAccountController")
@RequestMapping("/operation/bank-account")
@Api(tags = "运营端 - 银行账户信息相关接口")
public class BankAccountController {

    @Resource
    private IBankAccountService bankAccountService;

    @GetMapping("/{id}")
    @ApiOperation("根据服务人员/机构id查询银行账户信息")
    public BankAccountResDTO queryByServeProviderId(@PathVariable("id") Long id) {
        return BeanUtil.toBean(bankAccountService.getById(id), BankAccountResDTO.class);
    }
}
