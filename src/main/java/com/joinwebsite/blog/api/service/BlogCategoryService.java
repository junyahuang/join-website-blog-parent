package com.joinwebsite.blog.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryNewVO;


public interface BlogCategoryService {
    /**
     * @Description: 获取所有分类
     */
    IPage<BlogCategoryDTO> getAllCategory(int current, int pageSize);
    /**
     * @Description: 获取分类下的文章数量
     */
    int getArticleCountByCategory(BlogCategoryDTO blogCategoryDTO);
    /**
     * @param blogCategoryNewVO
     * @Description: 增加文章类型
     */
    boolean addCategory(BlogCategoryNewVO blogCategoryNewVO);
    /**
     * @Description: 删除文章类型
     */
    boolean deleteCategory(Long blogCategoryDTO);
    /**
     * @Description: 修改文章类型
     */
    boolean updateCategory(BlogCategoryDTO blogCategoryDTO);

    BlogCategoryDTO getCategoryById(Long id);
}
