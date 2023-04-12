package com.joinwebsite.blog.api.Injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * @Description: EasySqlInjector 自定义数据方法注入
 * @Author WangYejian
 */
public class EasySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        //防止父类方法不可用
        List<AbstractMethod> methods= super.getMethodList(mapperClass);
        methods.add(new InsertBatchSomeColumn());
        return methods;
    }
}
