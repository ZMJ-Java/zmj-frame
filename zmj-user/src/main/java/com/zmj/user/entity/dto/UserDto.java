package com.zmj.user.entity.dto;

import lombok.Data;

/**
 * @author ZMJ
 * @Package com.zmj.user.entity.dto
 * @date 2023/10/11 20:46
 */
@Data
public class UserDto {

    private String name;

    private Integer age;

    /**
     * 分页当前位置
     */
    private Integer pageIndex;
    /**
     * 分页大小
     */
    private Integer pageSize;
}
