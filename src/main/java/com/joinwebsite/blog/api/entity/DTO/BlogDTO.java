package com.joinwebsite.blog.api.entity.DTO;

import com.joinwebsite.blog.api.entity.VO.BlogCategoryVO;
import com.joinwebsite.blog.api.entity.VO.UserInBlogVO;
import lombok.Data;

import java.util.Date;

@Data
public class BlogDTO {
    private Long id;
    private BlogCategoryVO blogCategory;
    private UserInBlogVO author;
    private int commentNumber;
    private int viewNumber;
    private int likeNumber;
    private int isDeleted;
    private String title;
    private String description;
    private String htmlContent;
    private String markdownContent;
    private String thumb;
    private String toc;
    private Date createTime;
    private Date updateTime;

}
