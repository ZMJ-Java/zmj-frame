package com.zmj.user.convert;

import com.zmj.user.entity.SysUser;
import com.zmj.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ZMJ
 * @Package com.zmj.user.convert
 * @date 2023/10/13 14:14
 */
@Mapper
public interface SysUserConverter {
    SysUserConverter SYS_USER_CONVERTER = Mappers.getMapper(SysUserConverter.class);
    SysUser convertReqToSysUser(SysUserReq sysUserReq);

}
