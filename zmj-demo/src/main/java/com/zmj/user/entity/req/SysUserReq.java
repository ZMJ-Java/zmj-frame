package com.zmj.user.entity.req;

import com.zmj.bean.PageRequest;
import com.zmj.bean.PageResponse;
import com.zmj.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-10-13 13:14:26
 */
@Data
public class SysUserReq extends PageRequest implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer version;

}

