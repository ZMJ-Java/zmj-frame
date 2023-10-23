package com.zmj.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZMJ
 * @Package com.zmj.entity
 * @date 2023/10/12 15:34
 * @describe 实体类抽取公共字段
 */

@Data
public class BaseEntity implements Serializable {

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除字段
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    /**
     * mybatisplus的锁字段
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
