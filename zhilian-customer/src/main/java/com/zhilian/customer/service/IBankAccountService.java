package com.zhilian.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.customer.model.domain.BankAccount;
import com.zhilian.customer.model.dto.request.BankAccountUpsertReqDTO;
import com.zhilian.customer.model.dto.response.BankAccountResDTO;

/**
 * <p>
 * 银行账户 服务类
 * </p>
 *
 */
public interface IBankAccountService extends IService<BankAccount> {

    /**
     * 新增或更新
     *
     * @param bankAccountUpsertReqDTO 银行账号新增或更新模型
     */
    void upsert(BankAccountUpsertReqDTO bankAccountUpsertReqDTO);
}
