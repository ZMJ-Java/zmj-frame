package com.zmj.user.designPattern.responsibilityChainPattern;


import org.apache.commons.collections4.CollectionUtils;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.responsibilityChainPattern
 * @date 2023/10/24 19:38
 */
public class RuleCheckContext {
    /**
     * 规则检查结果
     */
    private RuleCheckResult ruleCheckResult = new RuleCheckResult();

    public RuleCheckResult getRuleCheckResult() {
        return ruleCheckResult;
    }

    public boolean hasError() {
        return CollectionUtils.isNotEmpty(ruleCheckResult.getFailedMsgList());
    }

}
