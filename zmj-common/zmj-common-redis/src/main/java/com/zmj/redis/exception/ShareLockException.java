package com.zmj.redis.exception;

/**
 * @author ZMJ
 * @Package com.zmj.redis.exception
 * @date 2023/10/16 14:12
 */
public class ShareLockException extends RuntimeException {
    public ShareLockException(String message) {
        super(message);
    }
}
