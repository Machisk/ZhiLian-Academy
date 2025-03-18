package com.zhilian.statemachine.core;

/**
 * 状态快照基础类
 */
public abstract class StateMachineSnapshot {

    /**
     * 返回快照id
     * @return
     */
    public abstract String getSnapshotId();
    /**
     * 返回快照状态
     * @return
     */
    public abstract Integer getSnapshotStatus();
    /**
     * 设置快照id
     */
    public abstract void setSnapshotId(String snapshotId);
    /**
     * 设置快照状态
     */
    public abstract void setSnapshotStatus(Integer snapshotStatus);
}
