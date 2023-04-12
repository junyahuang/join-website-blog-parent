package com.joinwebsite.blog.api.mapStruct;

import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.PO.BlogCategoryPO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryNewVO;
import com.joinwebsite.blog.api.entity.VO.BlogCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BlogCategoryTransferMapper {

    @Mappings({})
    BlogCategoryDTO PO2DTO(BlogCategoryPO blogCategoryPO);
    @Mappings({})
    BlogCategoryPO DTO2PO(BlogCategoryDTO blogCategoryDTO);
    @Mappings({})
    BlogCategoryVO PO2VO(BlogCategoryPO blogCategoryPO);
    @Mappings({})
    BlogCategoryPO NewVO2PO(BlogCategoryNewVO blogCategoryNewVO);
    /**
     * 提供默认方法，方法自己定义
     * @return
     */
    default BlogCategoryDTO toDTO() {
        return new BlogCategoryDTO();
    }

}
