package com.joinwebsite.blog.api.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insertFill start ...");

        //时间类型的字段自动填充
        this.setFieldValByName("createTime", new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //逻辑删除字段自动填充
        this.setFieldValByName("isDeleted",0,metaObject);
        //分类字段自动填充
        this.setFieldValByName("articleCount",0,metaObject);
        //博客字段自动填充
        this.setFieldValByName("commentNumber",0,metaObject);
        this.setFieldValByName("viewNumber",0,metaObject);
        this.setFieldValByName("likeNumber",0,metaObject);

    }
 
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill start ...");
 
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}