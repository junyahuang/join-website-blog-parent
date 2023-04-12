package com.joinwebsite.blog.api.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.DTO.BlogDTO;
import com.joinwebsite.blog.api.entity.PO.BlogPO;
import com.joinwebsite.blog.api.entity.PO.UserPO;
import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import com.joinwebsite.blog.api.entity.VO.BlogUpdateVO;
import com.joinwebsite.blog.api.entity.VO.UserInBlogVO;
import com.joinwebsite.blog.api.mapStruct.BlogTransferMapper;
import com.joinwebsite.blog.api.mapStruct.UserTransferMapper;
import com.joinwebsite.blog.api.mapper.BlogMapper;
import com.joinwebsite.blog.api.service.BlogCategoryService;
import com.joinwebsite.blog.api.service.BlogService;
import com.joinwebsite.blog.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogCategoryService blogCategoryService;
    @Autowired
    private BlogTransferMapper blogTransferMapper;
    @Autowired
    private UserTransferMapper userTransferMapper;
    /**
     * 添加博客
     *
     * @param blog
     * @return
     */
    @Override
    public boolean addBlog(BlogInsertVO blog) {
        //将blog转换为blogPO
        BlogPO blogPO = blogTransferMapper.NewVO2PO(blog);
        log.info("blogPO:{}",blogPO);
        //将blogPO插入数据库
        return blogMapper.insert(blogPO)>0;
    }

    /**
     * 根据id删除博客
     * @param id
     * @return
     */
    @Override
    public boolean deleteBlog(Long id) {
        //根据id删除博客
        return blogMapper.deleteById(id)>0;
    }

    /**
     * 修改博客
     * @param blog
     * @return
     */
    @Override
    public boolean updateBlog(BlogUpdateVO blog) {
        //将blog转换为blogPO
        BlogPO blogPO = blogTransferMapper.UpdateVO2PO(blog);
        //将blogPO更新到数据库
        return blogMapper.updateById(blogPO)>0;
    }

    /**
     * 根据id获取博客
     *
     * @param id
     * @return
     */
    @Override
    public BlogDTO getBlog(Long id) {
        //根据id查询数据库
        BlogPO blogPO = blogMapper.selectById(id);
        //如果查询结果为空，抛出异常
        if (blogPO == null) {
            throw new RuntimeException("该博客ID无法查询到博客");
        }
        return getDTO(blogPO);

    }

    /**
     * 根据博客PO获取博客DTO
     * @param blogPO
     * @return
     */
    private BlogDTO getDTO(BlogPO blogPO) {
        //根据博客的作者id查询作者信息
        UserPO userPO = userService.findUserById(blogPO.getAuthorId());
        //转换为UserInsertVO
        UserInBlogVO userInBlogVO = userTransferMapper.PO2INBLOGVO(userPO);
        //根据博客的分类id查询分类信息
        BlogCategoryDTO categoryById = blogCategoryService.getCategoryById(blogPO.getBlogCategoryId());
        //将blogPO转换为blogDTO返回
        return blogTransferMapper.PO2DTO(blogPO, userInBlogVO, categoryById);
    }

    /**
     * 分页获取博客
     *
     * @param current
     * @param size
     * @return
     */
    @Override
    public IPage<BlogDTO> getBlogList(int current, int size) {
        //包装分页参数
        IPage<BlogPO> page = new Page<>(current, size);
        //查询数据库
        IPage<BlogPO> blogPOIPage = blogMapper.selectPage(page, null);
        //将blogPO转换为blogDTO返回
        return blogPOIPage.convert(blogPO -> getDTO(blogPO));
    }
}
