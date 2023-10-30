package com.zmj.user.data_back;

import lombok.Data;

/**
 * 数据归档实体
 *
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:12
 */
@Data
public class BackUpDataRule {

    /**
     * 开始归档id
     * */
    private Long beginId;

    /**
     * 结束归档id
     * */
    private Long endId;

    /**
     * 一次查询条数
     * */
    private Long querySize;

}
