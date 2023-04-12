package com.joinwebsite.blog.api.mapStruct;

import com.joinwebsite.blog.api.entity.PO.UserPO;
import com.joinwebsite.blog.api.entity.VO.UserInBlogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserTransferMapper {
    @Mappings({
    })
    UserInBlogVO PO2INBLOGVO(UserPO userPO);
    @Mappings({
    })
    UserPO INBLOGVO2PO(UserInBlogVO userInBlogVO);
}
