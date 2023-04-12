package com.joinwebsite.blog.api.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("博客的新增类")
public class BlogInsertVO {
    @ApiModelProperty(name = "blogCategoryId", value = "博客的分类信息Id", required = true)
    @NotNull(message = "博客的分类信息Id不能为空")
    private Long blogCategoryId;
    @ApiModelProperty(name = "authorId", value = "作者ID", required = true)
    @NotNull(message = "作者ID不能为空")
    private Long authorId;
    @ApiModelProperty(name = "title", value = "博客的标题", required = true)
    @NotNull(message = "博客的标题不能为空")
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
