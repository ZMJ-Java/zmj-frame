package com.zmj.user.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author ZMJ
 * @Package com.zmj.user.event
 * @describe 事件监听
 * @date 2023/10/23 19:20
 */
@Service
@Slf4j
public class PersonEventListener {

    @TransactionalEventListener(fallbackExecution = true)
    public void listenCreateEvent(PersonChangeEvent personChangeEvent){
        switch (personChangeEvent.getOperateType()){
            case "create":
                log.info("创建事件：{}", JSON.toJSONString(personChangeEvent.getPerson()));
                break;
            case "execute":
                log.info("执行事件：{}", JSON.toJSONString(personChangeEvent.getPerson()));
                break;
            default:
                break;
        }



    }

}
