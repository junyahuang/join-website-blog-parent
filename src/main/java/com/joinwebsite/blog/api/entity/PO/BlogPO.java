package com.joinwebsite.blog.api.entity.PO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_blog")
public class BlogPO {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long blogCategoryId;
    private Long authorId;
    @TableField(fill = FieldFill.INSERT)
    private int commentNumber;
    @TableField(fill = FieldFill.INSERT)
    private int viewNumber;
    @TableField(fill = FieldFill.INSERT)
    private int likeNumber;
    @TableField(fill = FieldFill.INSERT)
    private int isDeleted;
    private String title;
    private String description;
    private String htmlContent;
    private String markdownContent;
    private String thumb;
    private String toc;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;

}
