package com.joinwebsite.blog.api.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("博客的更新类")
public class BlogUpdateVO {
    @ApiModelProperty(name = "id", value = "博客的id", required = true)
    @NotNull(message = "博客的id不能为空")
    private Long id;
    @ApiModelProperty(name = "blogCategoryId", value = "博客的分类信息Id")
    private Long blogCategoryId;
    @ApiModelProperty(name = "authorId", value = "作者ID")
    private Long authorId;
    @ApiModelProperty(name = "title", value = "博客的标题")
    private String title;
    @ApiModelProperty(name = "description", value = "博客的描述")
    private String description;
    @ApiModelProperty(name = "htmlContent", value = "博客的html内容")
    private String htmlContent;
    @ApiModelProperty(name = "markdownContent", value = "博客的markdown内容")
    private String markdownContent;
    @ApiModelProperty(name = "thumb", value = "博客的缩略图")
    private String thumb;
}
