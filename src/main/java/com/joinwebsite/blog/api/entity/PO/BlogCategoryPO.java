package com.joinwebsite.blog.api.entity.PO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_blogCategory")
public class BlogCategoryPO {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private int articleCount;
    private int weight;
    @TableField(fill = FieldFill.INSERT)
    private int isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
