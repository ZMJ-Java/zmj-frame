package com.zmj.user.event;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author ZMJ
 * @Package com.zmj.user.event
 * @date 2023/10/23 19:17
 */
@Getter
public class PersonChangeEvent extends ApplicationEvent {

    private Person person;

    private String operateType;

    public PersonChangeEvent(Person person, String operateType) {
        super(person);
        this.person = person;

        this.operateType = operateType;
    }


}
