package com.joinwebsite.blog.api;

import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.PO.BlogCategoryPO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryVO;
import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import com.joinwebsite.blog.api.mapStruct.BlogCategoryTransferMapper;
import com.joinwebsite.blog.api.mapStruct.BlogTransferMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapStructTest {

    @Autowired
    private BlogCategoryTransferMapper blogCategoryMapper;
    @Autowired
    private BlogTransferMapper blogTransferMapper;
    @Test
    public void BlogCategoryMapStructTest() {
        BlogCategoryDTO blogCategoryDTO = new BlogCategoryDTO();
        blogCategoryDTO.setId(1L);
        blogCategoryDTO.setName("test");
        System.out.println(blogCategoryDTO);
        BlogCategoryPO blogCategoryPO = blogCategoryMapper.DTO2PO(blogCategoryDTO);
        System.out.println(blogCategoryPO);
        //测试VO
        BlogCategoryVO blogCategoryVO = blogCategoryMapper.PO2VO(blogCategoryPO);
        System.out.println(blogCategoryVO);

    }
    @Test
    public void BlogTransferTest(){
        BlogInsertVO blogInsertVO = new BlogInsertVO();
        blogInsertVO.setAuthorId(1L);
        blogInsertVO.setBlogCategoryId(1L);
        blogInsertVO.setTitle("test");
        //转换为PO
        System.out.println(blogInsertVO);
        System.out.println(blogTransferMapper.NewVO2PO(blogInsertVO));

    }

}
