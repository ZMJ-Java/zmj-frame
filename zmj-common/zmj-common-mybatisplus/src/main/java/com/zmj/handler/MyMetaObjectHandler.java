package com.zmj.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZMJ
 * @Package com.zmj.handler
 * @date 2023/10/11 21:19
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createBy",String.class,"administrator");
        this.strictInsertFill(metaObject,"createTime",Date.class,new Date());
        this.strictInsertFill(metaObject,"deleteFlag",Integer.class,0);
        this.strictInsertFill(metaObject,"version",Integer.class,0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updateBy",String.class,"administrator");
        this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());
    }
}
