package com.joinwebsite.blog.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joinwebsite.blog.api.entity.DTO.BlogDTO;
import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import com.joinwebsite.blog.api.entity.VO.BlogUpdateVO;

public interface BlogService {
    /**
     * 添加博客
     * @param blog
     * @return
     */
    boolean addBlog(BlogInsertVO blog);

    /**
     * 根据id删除博客
     * @param id
     * @return
     */
    boolean deleteBlog(Long id);
    /**
     * 修改博客
     * @param blog
     * @return
     */
    boolean updateBlog(BlogUpdateVO blog);
    /**
     * 根据id获取博客
     * @param id
     * @return
     */
    BlogDTO getBlog(Long id);
    /**
     * 分页获取博客
     * @param current
     * @param size
     * @return
     */
    IPage<BlogDTO> getBlogList(int current, int size);

}
