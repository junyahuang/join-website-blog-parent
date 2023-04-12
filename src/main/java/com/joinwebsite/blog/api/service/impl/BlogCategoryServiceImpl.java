package com.joinwebsite.blog.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.PO.BlogCategoryPO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryNewVO;
import com.joinwebsite.blog.api.enums.ExceptionCodeEnum;
import com.joinwebsite.blog.api.exception.BizException;
import com.joinwebsite.blog.api.mapStruct.BlogCategoryTransferMapper;
import com.joinwebsite.blog.api.mapper.BlogCategoryMapper;
import com.joinwebsite.blog.api.service.BlogCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BlogCategoryServiceImpl implements BlogCategoryService {
    @Autowired
    private BlogCategoryMapper categoryMapper;
    @Autowired
    private BlogCategoryTransferMapper blogCategoryTransferMapper;
    /**
     * @Description: 获取所有分类，按weight排序
     */
    @Override
    public IPage<BlogCategoryDTO> getAllCategory(int current, int pageSize) {
        Page page = new Page(current, pageSize);
        //组装查询条件，按weight排序
        IPage<BlogCategoryPO> categoryPOIPage =
                categoryMapper.selectPage(page, (new QueryWrapper<BlogCategoryPO>()
                        .lambda().orderBy(true, true, BlogCategoryPO::getWeight)));
        //检查是否有数据
        if (categoryPOIPage.getRecords().size() == 0) {
            log.error("没有查询到分类");
            throw new BizException(ExceptionCodeEnum.ERROR, "没有查询到分类");
        }
        return categoryPOIPage.convert(blogCategoryTransferMapper::PO2DTO);
    }

    /**
     * @param blogCategoryDTO
     * @Description: 获取分类下的文章数量
     */
    @Override
    public int getArticleCountByCategory(BlogCategoryDTO blogCategoryDTO) {
        //将DTO转换为PO
        BlogCategoryPO blogCategoryPO = blogCategoryTransferMapper.DTO2PO(blogCategoryDTO);
        //根据分类id查询分类
        BlogCategoryPO categoryPO = categoryMapper.selectById(blogCategoryPO.getId());
        //如果分类存在
        if (categoryPO != null) {
            //返回分类下的文章数量
            return categoryPO.getArticleCount();
        }
        log.error("分类不存在");
        //抛出异常
        throw new BizException(ExceptionCodeEnum.ERROR, "无法找到该分类");
    }


    /**
     * @param blogCategoryNewVO
     * @Description: 增加文章类型
     */
    @Override
    public boolean addCategory(BlogCategoryNewVO blogCategoryNewVO) {
        //新增类型
        BlogCategoryPO blogCategoryPO = blogCategoryTransferMapper.NewVO2PO(blogCategoryNewVO);
        //使用lambda表达式根据insert的结果返回boolean
        return categoryMapper.insert(blogCategoryPO) > 0;
    }

    /**
     * @param id
     * @Description: 删除文章类型
     */
    @Override
    public boolean deleteCategory(Long id) {
        //根据id删除类型
        BlogCategoryPO blogCategoryPO = new BlogCategoryPO();
        return categoryMapper.deleteById(blogCategoryPO.getId()) > 0;
    }

    /**
     * @param blogCategoryDTO
     * @Description: 修改文章类型
     */
    @Override
    public boolean updateCategory(BlogCategoryDTO blogCategoryDTO) {
        //将DTO转换为PO
        BlogCategoryPO blogCategoryPO = blogCategoryTransferMapper.DTO2PO(blogCategoryDTO);
        //修改类型
        return categoryMapper.updateById(blogCategoryPO) > 0;
    }

    /**
     * @param id
     * @Description: 根据id获取文章类型
     */
    @Override
    public BlogCategoryDTO getCategoryById(Long id) {
        //根据id查询类型
        BlogCategoryPO blogCategoryPO = categoryMapper.selectById(id);
        //如果类型存在
        if (blogCategoryPO != null) {
            //返回类型
            return blogCategoryTransferMapper.PO2DTO(blogCategoryPO);
        }
        log.error("分类不存在");
        //抛出异常
        throw new BizException(ExceptionCodeEnum.ERROR, "无法找到该分类");
    }
}
