package com.zhilian.mysql.interceptor;

import com.zhilian.common.handler.UserInfoHandler;
import com.zhilian.common.model.CurrentUserInfo;
import com.zhilian.common.utils.ObjectUtils;
import com.zhilian.common.utils.ReflectUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.zhilian.mysql.constants.DbFiledConstants;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;

import java.sql.SQLException;

public class MyBatisAutoFillInterceptor implements InnerInterceptor {

    private final UserInfoHandler userInfoHandler;

    public MyBatisAutoFillInterceptor(UserInfoHandler userInfoHandler) {
        this.userInfoHandler = userInfoHandler;
    }

    @Override
    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        //1.更新操作
        updateExe(parameter);
        //2.插入操作
        insertExe(ms, parameter);
    }

    private void insertExe(MappedStatement ms, Object parameter){
        //1.判断当前操作是否是插入操作
        if(ms.getSqlCommandType().compareTo(SqlCommandType.INSERT) == 0) {
            //2.判断是否有updater字段，如果
            if(ObjectUtils.isNotNull(parameter) && ReflectUtils.containField(DbFiledConstants.CREATE_BY, parameter.getClass())){

                //3.有userId也存在并设置updater
                Long userId = currentUserId();
                if(ObjectUtils.isNotNull(userId)){
                    //4.当前操作人设置到创建人字段
                    ReflectUtils.setFieldValue(parameter, DbFiledConstants.CREATE_BY, currentUserId());
                }
            }
        }
    }

    private void updateExe(Object parameter){
        //1.判断是否有updater字段
        if(ObjectUtils.isNotNull(parameter) && ReflectUtils.containField(DbFiledConstants.UPDATE_BY, parameter.getClass())){
            Long userId = currentUserId();
            //2.如果有userId也存在并设置updater
            if(ObjectUtils.isNotNull(userId)){
                //3.当前用户设置到更新人字段
                ReflectUtils.setFieldValue(parameter, DbFiledConstants.UPDATE_BY, userId);
            }
        }
    }

    private Long currentUserId() {
        if(ObjectUtils.isNull(userInfoHandler)){
            return null;
        }
        CurrentUserInfo currentUserInfo = userInfoHandler.currentUserInfo();
        return currentUserInfo != null ? currentUserInfo.getId() : null;
    }
}
