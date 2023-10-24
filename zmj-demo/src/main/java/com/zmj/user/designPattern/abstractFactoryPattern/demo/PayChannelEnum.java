package com.zmj.user.designPattern.abstractFactoryPattern.demo;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.abstractFactoryPattern.demo
 * @date 2023/10/17 19:03
 */
@Getter
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

    public static final Map<Integer, PayChannelEnum> clientChannelMap
            = Stream.of(PayChannelEnum.values()).collect(Collectors.toMap(e -> e.getCode(), e -> e));

    public static PayChannelEnum getChannel(Integer code) {
        PayChannelEnum payChannelEnum = clientChannelMap.get(code);
        return payChannelEnum;
    }

    /**
     * 根据code值获取枚举值
     */
    public static PayChannelEnum getPayChannelByCode(int codeVal) {
        for (PayChannelEnum payChannelEnum : PayChannelEnum.values()) {
            if (payChannelEnum.code == codeVal) {
                return payChannelEnum;
            }
        }
        return null;
    }


}
