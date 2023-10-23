package com.zmj.redis.delayQueue;

import lombok.Data;

import java.util.Date;

/**
 * @author ZMJ
 * @Package com.zmj.redis.delayQueue
 * @date 2023/10/23 19:39
 */
@Data
public class MassMailTask {

    private Long taskId;

    private Date startTime;
}
