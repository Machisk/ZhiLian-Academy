package com.zhilian.customer.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.customer.mapper.BankAccountMapper;
import com.zhilian.customer.model.domain.BankAccount;
import com.zhilian.customer.model.dto.request.BankAccountUpsertReqDTO;
import com.zhilian.customer.service.IBankAccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行账户 服务实现类
 * </p>
 *
 */
@Service
public class BankAccountServiceImpl extends ServiceImpl<BankAccountMapper, BankAccount> implements IBankAccountService {

    /**
     * 新增或更新
     *
     * @param bankAccountUpsertReqDTO 银行账号新增或更新模型
     */
    @Override
    public void upsert(BankAccountUpsertReqDTO bankAccountUpsertReqDTO) {
        BankAccount bankAccount = BeanUtil.toBean(bankAccountUpsertReqDTO, BankAccount.class);
        super.saveOrUpdate(bankAccount);
    }
}
