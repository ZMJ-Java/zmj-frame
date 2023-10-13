package com.zmj.user.entity.req;

import lombok.Data;

/**
 * @author ZMJ
 * @Package com.zmj.user.entity.req
 * @date 2023/10/12 21:41
 */
@Data
public class UserListReq {
    /**
     * 分页当前位置
     */
    private Integer pageIndex;
    /**
     * 分页大小
     */
    private Integer pageSize;
}
