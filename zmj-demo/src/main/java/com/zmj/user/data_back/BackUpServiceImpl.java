package com.zmj.user.data_back;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author ZMJ
 * @Package com.zmj.user.data_back
 * @date 2023/10/30 23:37
 */
@Service
@Slf4j
public class BackUpServiceImpl implements BackUpService{
    @Resource
    private BackUpDataFactory backUpDataFactory;

    @Override
    public void backUp(BackUpDataSceneEnum sceneEnum) {
        log.info("BackUpServiceImpl.backUp.scene:{}!", sceneEnum.getCode());
        BackUpDataHandler backUpDataHandler = backUpDataFactory.getHandlerByCode(sceneEnum.getCode());
        if (Objects.isNull(backUpDataHandler)) {
            log.info("BackUpServiceImpl.noFindScene!");
            return;
        }
        backUpDataHandler.backUpData();
    }
}
