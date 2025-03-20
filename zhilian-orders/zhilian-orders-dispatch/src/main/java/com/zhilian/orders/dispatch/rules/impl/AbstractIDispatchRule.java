package com.zhilian.orders.dispatch.rules.impl;

import com.zhilian.common.utils.CollUtils;
import com.zhilian.orders.dispatch.rules.IDispatchRule;
import com.zhilian.orders.dispatch.model.dto.ServeProviderDTO;
import lombok.Setter;

import java.util.List;

@Setter
public abstract class AbstractIDispatchRule implements IDispatchRule {
    /**
     * 下一条规则
     */
    private IDispatchRule next;

    public AbstractIDispatchRule(IDispatchRule next) {
        this.next = next;
    }

    public abstract List<ServeProviderDTO> doFilter(List<ServeProviderDTO> originServeProviderDTOS);

    @Override
    public List<ServeProviderDTO> filter(List<ServeProviderDTO> serveProviderDTOS) {
        List<ServeProviderDTO> result = this.doFilter(serveProviderDTOS);
        if(CollUtils.size(result) > 1 && next != null) {
            return next.filter(result);
        }else {
            return result;
        }
    }

    @Override
    public IDispatchRule next() {
        return next;
    }
}
