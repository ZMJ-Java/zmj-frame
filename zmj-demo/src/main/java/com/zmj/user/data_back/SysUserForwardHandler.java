package com.zmj.user.data_back;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.zmj.user.dao.SysUserBackDao;
import com.zmj.user.dao.SysUserDao;
import com.zmj.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:34
 */
@Slf4j
@Component
public class SysUserForwardHandler extends AbstractBackUpDataHandler<SysUser,SysUserBackUpRule>{
    /**
     * 归档规则，可以配合nacos动态配置
     * (设置为String格式的json，与SysUserBackUpRule中的参数一一对应)
     */
    private String sysUserBackupRuleStr;

    /**
     * 佣金系数归档停止flag，可以配合nacos动态配置
     * (可以随时停止归档)
     */
    private Boolean stopFlag;

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserBackDao sysUserBackDao;

    @Override
    public Boolean needStop() {
        return stopFlag;
    }

    @Override
    public BackUpDataSceneEnum getScene() {
        return BackUpDataSceneEnum.USER_FORWARD;
    }

    @Override                      
    public List<SysUser> queryData(SysUserBackUpRule rule) {
        SysUser sysUser = new SysUser();
        List<SysUser> sysUserList = sysUserDao.queryAll(sysUser);
        return sysUserList;
    }

    @Override
    public void insertData(List<SysUser> sysUserList) {
        sysUserBackDao.insertBatch(sysUserList);
    }

    @Override
    public void deleteData(List<SysUser> dataList) {
        List<Long> ids = dataList.stream().map(SysUser::getId).collect(Collectors.toList());
        sysUserDao.batchDelete(ids);
    }

    @Override
    public SysUserBackUpRule getRule() {
        SysUserBackUpRule backUpRule = JSON.parseObject(sysUserBackupRuleStr, SysUserBackUpRule.class);
        Preconditions.checkNotNull(backUpRule, "归档规则不能为空！");
        Preconditions.checkNotNull(backUpRule.getQuerySize(), "查询数量不能为空！");
        Preconditions.checkNotNull(backUpRule.getBeginId(), "beginId不能为空！");
        Long endId = backUpRule.getBeginId() + backUpRule.getQuerySize();
        backUpRule.setEndId(endId);
        return backUpRule;
    }

    @Override
    public SysUserBackUpRule changeOffSet(SysUserBackUpRule backupDataRule) {
        backupDataRule.setBeginId(backupDataRule.getEndId());
        Long endId = backupDataRule.getBeginId() + backupDataRule.getQuerySize();
        backupDataRule.setEndId(endId);
        return backupDataRule;
    }
}
