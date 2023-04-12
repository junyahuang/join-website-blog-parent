package com.joinwebsite.blog.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joinwebsite.blog.api.entity.PO.BlogCategoryPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface BlogCategoryMapper extends BaseMapper<BlogCategoryPO> {

}
