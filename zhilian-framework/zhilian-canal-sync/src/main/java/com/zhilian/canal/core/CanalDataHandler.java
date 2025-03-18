package com.zhilian.canal.core;

import java.util.List;

public interface CanalDataHandler<T> {

    /**
     * 批量保存
     * @param data
     */
    void batchSave(List<T> data);

    /**
     * 批量删除
     * @param ids
     */
    void batchDelete(List<Long> ids);
}
