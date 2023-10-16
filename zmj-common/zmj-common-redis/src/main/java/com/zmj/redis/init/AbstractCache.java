package com.zmj.redis.init;

import org.springframework.stereotype.Component;

/**
 * @author ZMJ
 * @Package com.zmj.redis.init
 * @date 2023/10/16 8:23
 */
@Component
public abstract class AbstractCache {

    /**由业务代码自己具体去实现*/
    public void initCache(){

    }

    public <T> T getCache(String key){
        return null;
    }

    public void clearCache(){}

    public void reloadCache(){
        clearCache();
        initCache();
    }


}
