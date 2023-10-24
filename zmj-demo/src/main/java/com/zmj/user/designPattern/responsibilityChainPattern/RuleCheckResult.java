package com.zmj.user.designPattern.responsibilityChainPattern;

import lombok.Data;

import java.util.List;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.responsibilityChainPattern
 * @date 2023/10/24 19:37
 */
@Data
public class RuleCheckResult {

    /**
     * 失败信息列表
     * */
    private List<String> failedMsgList;

}
