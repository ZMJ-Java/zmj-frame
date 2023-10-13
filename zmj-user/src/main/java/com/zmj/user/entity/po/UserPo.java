package com.zmj.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.zmj.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author ZMJ
 * @Package com.zmj.user.entity.po
 * @date 2023/10/11 16:17
 */
@TableName("user")
@Data
public class UserPo extends BaseEntity {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

}
