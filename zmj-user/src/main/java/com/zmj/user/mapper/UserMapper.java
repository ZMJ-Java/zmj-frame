package com.zmj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zmj.user.entity.po.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @author ZMJ
 * @Package com.zmj.user.mapper
 * @date 2023/10/11 16:16
 */
@Repository
public interface UserMapper extends BaseMapper<UserPo> {
    IPage<UserPo> getUserPage(IPage<UserPo> userPoIPage);
}
