package com.zmj.user.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZMJ
 * @Package com.zmj.user.event
 * @describe 事件发布
 * @date 2023/10/23 19:19
 */
@Service
@Slf4j
public class PersonEventService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public  void createPerson(Person person){
        applicationEventPublisher.publishEvent(new PersonChangeEvent(person,"create"));
    }

    public void  executePerson(Person person){
        applicationEventPublisher.publishEvent(new PersonChangeEvent(person,"execute"));
    }

}
