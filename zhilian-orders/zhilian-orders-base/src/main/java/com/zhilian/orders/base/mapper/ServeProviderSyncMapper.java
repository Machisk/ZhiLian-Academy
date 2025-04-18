package com.zhilian.orders.base.mapper;

import com.zhilian.orders.base.model.domain.ServeProviderSync;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 机构服务端更新服务时间 Mapper 接口
 * </p>
 *
 */
public interface ServeProviderSyncMapper extends BaseMapper<ServeProviderSync> {

//    @Update("update serve_provider_sync set serve_times=JSON_ARRAY_APPEND(serve_times,'$',#{serveTime})," +
//            "acceptance_num=acceptance_num+1 where id=#{id}")
//    int addServeTimes(@Param("id")Long id, @Param("serveTime") Integer serveTime);
}
