package com.joinwebsite.blog.api.mapStruct;

import com.joinwebsite.blog.api.entity.DTO.BlogCategoryDTO;
import com.joinwebsite.blog.api.entity.DTO.BlogDTO;
import com.joinwebsite.blog.api.entity.PO.BlogPO;
import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import com.joinwebsite.blog.api.entity.VO.BlogUpdateVO;
import com.joinwebsite.blog.api.entity.VO.UserInBlogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BlogTransferMapper {
    @Mappings({
        @Mapping(source = "blogCategoryDTO",target = "blogCategory"),
        @Mapping(source = "userInBlogVO",target = "author"),
        @Mapping(source = "blogPO.id",target = "id"),
        @Mapping(source = "blogPO.description",target = "description"),
    })
    BlogDTO PO2DTO(BlogPO blogPO, UserInBlogVO userInBlogVO, BlogCategoryDTO blogCategoryDTO);
    @Mappings({
        @Mapping(source = "blogCategory.id",target = "blogCategoryId"),
        @Mapping(source = "author.id",target = "authorId"),
    })
    BlogPO DTO2PO(BlogDTO blogDTO);
    @Mappings({
        @Mapping(source = "blogCategoryId",target = "blogCategoryId"),
        @Mapping(source = "authorId",target = "authorId"),
    })
    BlogPO NewVO2PO(BlogInsertVO blogInsertVO);
    @Mappings({})
    BlogPO UpdateVO2PO(BlogUpdateVO blog);

}
