package com.joinwebsite.blog.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joinwebsite.blog.api.entity.DTO.BlogDTO;
import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import com.joinwebsite.blog.api.entity.VO.BlogUpdateVO;
import com.joinwebsite.blog.api.exception.CosmoController;
import com.joinwebsite.blog.api.exception.Result;
import com.joinwebsite.blog.api.service.BlogService;
import com.joinwebsite.blog.api.utils.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@Validated
@CosmoController
@CrossOrigin
@RequestMapping("/blog")
/**
 * 博客管理Controller
 */
@Api(value = "博客管理Controller",tags = "博客管理接口")
public class BlogController {
    @Autowired
    private BlogService blogService;
    /**
     * 添加博客
     *
     * @param blog
     * @return
     */
    @PostMapping("")
    @ApiOperation(value = "添加博客", notes = "添加博客")
    public Result<Object>  addBlog(@ApiParam(value = "博客基本信息", required = true)
            @RequestBody BlogInsertVO blog) {
        //参数校验
        ValidationUtils.validateReq(blog,true);
        blogService.addBlog(blog);
        return Result.success("博客添加成功");
    }
    /**
     * 根据id删除博客
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除博客", notes = "根据id删除博客")
    public Result<Object>  deleteBlog(@NotNull(message = "博客id不能为空")
            @ApiParam(value = "博客id", required = true)
            @PathVariable Long id) {
            blogService.deleteBlog(id);
            return Result.success("博客删除成功");
    }
    /**
     * 修改博客
     * @param blog
     * @return
     */
    @PutMapping("")
    @ApiOperation(value = "修改博客", notes = "修改博客")
    public Result<Object> updateBlog(@ApiParam(value = "博客基本信息", required = true)
                                    @RequestBody BlogUpdateVO blog) {
        //参数校验
        ValidationUtils.validateReq(blog,true);
        blogService.updateBlog(blog);
        return Result.success("博客修改成功");
    }
    /**
     * 根据id获取博客
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取博客", notes = "根据id获取博客")
    public BlogDTO getBlog(@NotNull(message = "博客id不能为空")
            @ApiParam(value = "博客id", required = true)
            @PathVariable Long id) {
        return blogService.getBlog(id);
    }
    /**
     * 分页获取博客列表
     */
    @GetMapping("/{page}/{size}")
    @ApiOperation(value = "分页获取博客列表", notes = "分页获取博客列表")
    public IPage<BlogDTO> getBlogList(@NotNull(message = "页码不能为空")
                            @Min(value = 1,message = "页码不能小于1")
                            @ApiParam(value = "页码", required = true)
                            @PathVariable Integer page,
                            @NotNull(message = "每页数量不能为空")
                            @Min(value = 1,message = "每页数量不能小于1")
                            @Max(value = 100,message = "每页数量不能大于100")
                            @ApiParam(value = "每页数量", required = true)
                            @PathVariable Integer size) {
        return blogService.getBlogList(page,size);
    }

}
