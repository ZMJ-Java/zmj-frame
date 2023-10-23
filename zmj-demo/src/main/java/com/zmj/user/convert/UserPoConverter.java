package com.zmj.user.convert;

import com.zmj.user.entity.dto.UserDto;
import com.zmj.user.entity.po.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author ZMJ
 * @Package com.zmj.user.convert
 * @date 2023/10/13 14:24
 */
@Mapper
public interface UserPoConverter {

    UserPoConverter USER_PO_CONVERTER = Mappers.getMapper(UserPoConverter.class);
//    @Mapping(target = "name")
//    @Mapping(target = "age")
    UserPo converterToUserPo(UserDto userDto);

}
