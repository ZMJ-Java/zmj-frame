package com.zmj.bean;

import lombok.Data;

/**
 * @author ZMJ
 * @Package com.zmj.bean
 * @date 2023/10/13 13:29
 */
@Data
public class PageRequest {

    private Long pageNo = 1L;

    private Long pageSize = 10L;

    public Long getPageNo() {
        if (pageNo < 1 || pageNo == null || pageNo > Long.MAX_VALUE) {
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize() {
        if (pageSize < 1 || pageSize == null || pageSize > Long.MAX_VALUE) {
            return 10L;
        }
        return pageSize;
    }

}
