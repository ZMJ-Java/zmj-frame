package com.zmj.user.entity;

import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-10-13 13:14:26
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = -63959515769475332L;
    @ApiParam("唯一id")
    private Long id;
    @ApiParam("名称")
    private String name;
    @ApiParam("年龄")
    private Integer age;
    @ApiParam("创建者名称")
    private String createBy;
    @ApiParam("创建时间")
    private Date createTime;
    @ApiParam("更新者名称")
    private String updateBy;
    @ApiParam("更新时间")
    private Date updateTime;
    @ApiParam("删除标识")
    private Integer deleteFlag;
    @ApiParam("版本")
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

