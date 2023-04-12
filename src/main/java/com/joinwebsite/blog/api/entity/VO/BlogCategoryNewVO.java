package com.joinwebsite.blog.api.entity.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("博客分类的新增VO")
public class BlogCategoryNewVO {
    @ApiModelProperty(name = "name", value = "博客的类别名", required = true)
    @NotNull(message = "博客的类别名不能为空")
    private String name;
    @ApiModelProperty(name = "weight", value = "排序权重", required = true)
    @NotNull(message = "排序权重不能为空")
    @Min(value = 1, message = "排序权重不能小于0")
    @Max(value = 6, message = "排序权重不能大于6")
    private int weight;

    public BlogCategoryNewVO(String name, int weight) {
    }
}
