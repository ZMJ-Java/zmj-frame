package com.zmj.user.designPattern.filterPattern.entity;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.filterPattern
 * @date 2023/10/18 19:04
 */
public enum ArticleFilterEnum {

    WORD_COUNT(0, "字数过滤");

    private int code;

    private String desc;

    ArticleFilterEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值获取渠道枚举
     */
    public static ArticleFilterEnum getEnumByCode(int codeVal) {
        for (ArticleFilterEnum channelEnum : ArticleFilterEnum.values()) {
            if (channelEnum.code == codeVal) {
                return channelEnum;
            }
        }
        return null;
    }

    /**
     * 根据code值获取的desc
     * */
    public static String getValueByCode(int code){
        ArticleFilterEnum[] values = ArticleFilterEnum.values();
        for (ArticleFilterEnum channelEnum : values) {
            if (channelEnum.code == code){
                return channelEnum.desc;
            }
        }
        return null;
    }


}
