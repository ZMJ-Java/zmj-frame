package com.zmj.user.data_back;

/**
 * 数据归档场景枚举
 *
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:04
 */
public enum BackUpDataSceneEnum {
    USER_FORWARD("user_forward","用户数据归档正向，由sys_user归档到sys_user_backup"),
    USER_BACKWARD("user_backward","用户数据归档逆向，由sys_user_backup归档到sys_usr");

    String code;

    String desc;

    BackUpDataSceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取数据归档场景编码
     *
     * @return 数据归档场景编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 根据数据归档场景编码值获取渠道枚举
     *
     * @param codeVal 数据归档场景编码
     * @return 与codeVal值相应的BackUpDataSceneEnum对象
     */
    public static BackUpDataSceneEnum getByCode(String codeVal) {
        for (BackUpDataSceneEnum backUpDataSceneEnum : BackUpDataSceneEnum.values()) {
            if (codeVal.equals(backUpDataSceneEnum.code)) {
                return backUpDataSceneEnum;
            }
        }
        return null;
    }


}
