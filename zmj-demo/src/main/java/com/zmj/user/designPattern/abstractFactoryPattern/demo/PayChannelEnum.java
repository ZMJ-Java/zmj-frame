package com.zmj.user.designPattern.abstractFactoryPattern.demo;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo
 * @date 2023/10/17 19:03
 */
public enum PayChannelEnum {
    WeChatPay(0, "微信支付"),
    ZhiFuBaoPay(1, "支付宝支付"),
    BankCardPay(2, "银行卡支付"),
    ;

    /**
     * 代码
     */
    private int code;
    /**
     * 描述
     */
    private String desc;

    PayChannelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值获取枚举值
     */
    public static PayChannelEnum getPayChannelByCode(int codeVal) {
        for (PayChannelEnum payChannelEnum : PayChannelEnum.values()) {
            if (payChannelEnum.code == codeVal){
                return payChannelEnum;
            }
        }
        return null;
    }


}
