package com.zmj.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zmj.entity.BaseEntity;
import io.swagger.annotations.ApiParam;
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
@TableName("sys_user")
public class SysUser implements Serializable {

    @ApiParam("唯一id")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @ApiParam("名称")
    private String name;
    @ApiParam("年龄")
    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer version;



}

