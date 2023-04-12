package com.joinwebsite.blog.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joinwebsite.blog.api.entity.PO.BlogPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BlogMapper extends BaseMapper<BlogPO> {

}
