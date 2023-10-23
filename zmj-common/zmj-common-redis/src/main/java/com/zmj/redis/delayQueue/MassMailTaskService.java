package com.zmj.redis.delayQueue;

import com.alibaba.fastjson.JSON;
import com.zmj.redis.util.RedisUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZMJ
 * @Package com.zmj.redis.delayQueue
 * @date 2023/10/23 19:40
 */
@Service
@Slf4j
public class MassMailTaskService {

    @Resource
    private RedisUtil redisUtil;


    private static final String MASS_TASK_KEY = "massTaskMail";

    public void pushMassMailTaskQueue(MassMailTask massMailTask) {
        Date startTime = massMailTask.getStartTime();

        if (startTime == null) {
            return;
        }

        if (startTime.compareTo(new Date()) <= 0) {
            return;
        }

        log.info("定时任务加入队列：{}", JSON.toJSONString(massMailTask));

        redisUtil.zAdd(MASS_TASK_KEY, massMailTask.getTaskId().toString(), startTime.getTime());

    }


    public Set<Long> poolMassTaskQueue() {
        Set<String> taskIdSet = redisUtil.rangeByScore(MASS_TASK_KEY, 0, System.currentTimeMillis());

        if (CollectionUtils.isEmpty(taskIdSet)) {
            return Collections.emptySet();
        }

        redisUtil.removeZsetList(MASS_TASK_KEY, taskIdSet);
        return taskIdSet.stream().map(n -> Long.parseLong(n)).collect(Collectors.toSet());

    }


}
