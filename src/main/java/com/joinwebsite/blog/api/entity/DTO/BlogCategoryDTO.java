package com.joinwebsite.blog.api.entity.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class BlogCategoryDTO {
    @ApiModelProperty(name = "id", value = "博客的ID", required = true)
    @NotNull(message = "博客的ID不能为空")
    private long id;
    @ApiModelProperty(name = "name", value = "博客的类别名")
    private String name;
    @ApiModelProperty(name = "weight", value = "排序权重")
    private int weight;
}
