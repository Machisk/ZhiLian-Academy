package com.zhilian.redis.handler;

import com.zhilian.redis.model.SyncMessage;

import java.util.List;

public interface SyncProcessHandler<T> {

    /**
     * 批量处理同步队列中的数据
     *
     * @param multiData
     */
    void batchProcess(List<SyncMessage<T>> multiData);

    /**
     * 单一处理数据
     *
     * @param singleData
     */
    void singleProcess(SyncMessage<T> singleData);
}
