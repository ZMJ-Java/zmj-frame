package com.zmj.user.data_back;

import com.alibaba.fastjson.JSON;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:11
 */
@Slf4j
@Component
public abstract class AbstractBackUpDataHandler<T, V extends BackUpDataRule> implements BackUpDataHandler {

    /**
     * 最大循环次数，后续可以配合nacos动态配置
     */
    private Integer maxLoopCount = 10;

    @Resource
    private TransactionTemplate transactionTemplate;

    /**
     * 归档数据方法
     */
    @Override
    public void backUpData() {
        // 打印开始备份数据的日志
        log.info("AbstractBackUpDataHandler.backUpData.start.scene:{}!", getScene().getCode());
        // 获取查询规则
        V rule = getRule();
        // 初始化loopCount为0
        Integer loopCount = 0;
        // 打印获取查询规则的日志
        log.info("AbstractBackUpDataHandler.backUpData.getRule.scene:{},rule:{}", getScene().getCode(), JSON.toJSONString(rule));
        // 反复进行数据备份，直到needStop()方法返回true或者loopCount大于等于maxLoopCount
        while (!needStop()) {
            // 打印stopFlag状态的日志
            log.info("AbstractBackUpDataHandler.backUpData.stopFlag.scene:{},stopFlag:{}", getScene().getCode(), needStop());
            // 查询需要备份的数据
            List<T> dataList = queryData(rule);
            // 如果查询结果为空，根据maxLoopCount和当前loopCount的大小关系来判断是否跳出循环
            if (CollectionUtils.isEmpty(dataList)) {
                // 打印查询结果为空的日志
                log.info("AbstractBackUpDataHandler.backUpData.queryIsEmpty.scene:{}", getScene().getCode());
                if (loopCount >= maxLoopCount) {
                    // 打印到达备份处理最大次数的日志
                    log.info("AbstractBackUpDataHandler.backUpData.arriveMaxCount.scene:{}", getScene().getCode());
                    break;
                }
                // 改变查询规则中的offset值
                rule = changeOffSet(rule);
                // loopCount加1
                loopCount++;
                continue;
            }
            // 将loopCount重置为0
            loopCount = 0;
            // 打印查询结果的日志
            log.info("AbstractBackUpDataHandler.backUpData.querySize.scene:{},size:{}", getScene().getCode(), dataList.size());
            // 初始化一个AtomicReference对象，用于事务处理的标记
            AtomicReference<Boolean> transactionSuccessFlag = new AtomicReference<>(true);
            // 执行事务处理操作
            transactionTemplate.execute((transactionStatus) -> {
                try {
                    // 将查询结果插入到备份表中
                    insertData(dataList);
                    // 根据查询结果，从原表中删除数据
                    deleteData(dataList);
                } catch (Exception e) {
                    // 打印事务处理失败的日志，并将transactionSuccessFlag置为false
                    log.error("AbstractBackUpDataHandler.backUpData.transferData.fail.scene:{},error:{}", getScene().getCode(), e.getMessage(), e);
                    transactionSuccessFlag.set(false);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            });
            // 如果事务处理失败，跳出循环
            if (!transactionSuccessFlag.get()) {
                // 打印事务处理失败的日志
                log.info("AbstractBackUpDataHandler.backUpData.transactionFail.scene:{}", getScene().getCode());
                break;
            }
            // 改变查询规则中的offset值
            rule = changeOffSet(rule);
        }
    }

    /**
     * 是否停止
     */
    public abstract Boolean needStop();

    /**
     * 归档规则
     */
    public abstract V getRule();

    /**
     * 归档偏移量变更
     */
    public abstract V changeOffSet(V backupDataRule);

    /**
     * 查询数据
     */
    public abstract List<T> queryData(V backUpDataRule);

    /**
     * 插入数据
     */
    public abstract void insertData(List<T> dataList);

    /**
     * 删除数据
     */
    public abstract void deleteData(List<T> dataList);

    /**
     * 场景定义
     */
    @Override
    public abstract BackUpDataSceneEnum getScene();
}
