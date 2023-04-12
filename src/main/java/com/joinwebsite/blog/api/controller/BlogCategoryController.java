package com.joinwebsite.blog.api.controller;

import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryNewVO;
import com.joinwebsite.blog.api.exception.CosmoController;
import com.joinwebsite.blog.api.exception.Result;
import com.joinwebsite.blog.api.service.BlogCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Slf4j
@Validated
@CosmoController
@CrossOrigin
@RequestMapping("/blogCategories")
/**
 * 博客类别管理Controller
 */
@Api(value = "博客类别管理Controller",tags = "博客类别管理接口")
public class BlogCategoryController {
    @Autowired
    private BlogCategoryService blogCategoryService;
    //增加类别
    @PostMapping()
    @ApiOperation(value = "增加类别",notes = "增加类别",httpMethod = "POST")
    public Result<Object> addCategory(@ApiParam(name = "博客类别")
            @RequestBody BlogCategoryNewVO blogCategoryNewVO){
        boolean b = blogCategoryService.addCategory(blogCategoryNewVO);
        return Result.success("增加博客类别标签成功");
    }
    //删除类别
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除类别",notes = "删除类别",httpMethod = "DELETE")
    public Result<Object> deleteCategory(@ApiParam(name="id",value = "博客的ID",required = true)
                                             @PathVariable("id") Long id){
        //调用service层，根据flag判断是否删除成功，使用lambda表达式
        boolean flag = blogCategoryService.deleteCategory(id);
        return Result.success();
    }
    //修改类别
    @PutMapping()
    @ApiOperation(value = "修改类别",notes = "修改类别",httpMethod = "PUT")
    public Result<Object> updateCategory(@ApiParam(name = "博客类别")
                                             @RequestBody BlogCategoryDTO blogCategoryDTO){
        //调用service层，根据flag判断是否修改成功，使用lambda表达式
        boolean flag = blogCategoryService.updateCategory(blogCategoryDTO);
        if(flag){
            return Result.success("修改博客类别成功");
        }
        throw new RuntimeException("修改博客类别失败");

    }
    //分页查询类别
    @GetMapping("/{currentPage}/{pageSize}")
    @ApiOperation(value = "分页查询类别",notes = "分页查询类别，按weight排序",httpMethod = "GET")
    public Object queryCategory(@ApiParam(name = "currentPage",value = "当前页码",required = true)
                                            @Min(value = 1,message = "当前页码不能小于1")
                                            @PathVariable("currentPage") int currentPage,
                                            @ApiParam(name = "pageSize",value = "每页数量",required = true)
                                            @Min(value = 1,message = "每页数量不能小于1")
                                            @Max(value = 1000,message = "每页数量不能大于1000")
                                            @PathVariable("pageSize") int pageSize){
        return blogCategoryService.getAllCategory(currentPage, pageSize);
    }

}
