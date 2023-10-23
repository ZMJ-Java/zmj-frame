package com.zmj.user.controller;

import com.zmj.bean.Result;
import com.zmj.redis.util.LocalCacheUtil;
import com.zmj.redis.util.RedisShareLockUtil;
import com.zmj.redis.util.RedisUtil;
import com.zmj.tool.ExportWorldUtil;
import com.zmj.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author ZMJ
 * @Package com.zmj.user.controller
 * @date 2023/10/11 10:07
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LocalCacheUtil localCacheUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisShareLockUtil redisShareLockUtil;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "hello world";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testRedis")
    public Result testRedis() {
//        redisTemplate.opsForValue().set("日期","10_13");
        String str = (String) redisTemplate.opsForValue().get("日期");
        String string = redisUtil.get("日期");
        System.out.println(redisTemplate.opsForValue().get("日期").getClass());
        System.out.println(str);
        return Result.ok(string);
//        redisTemplate.opsForHash().put();
//        redisTemplate.opsForSet()
//        redisTemplate.opsForZSet()

    }

    @RequestMapping(method = RequestMethod.GET, value = "/testRedisLock")
    public Boolean testRedisLock() {

        boolean result = redisShareLockUtil.lock("zmj", "12434", 10000L);
        System.out.println(result);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testLog")
    public void testLog() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            log.info("这个是第{}日志", i);
        }
        long endTime = System.currentTimeMillis();
        log.info("当前日志花费时间: {}s", endTime - startTime);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testExport")
    public void testExport() throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "TextFile");
        dataMap.put("auditName", "詹茂钧");
        ExportWorldUtil.exportWord(dataMap, "导出的文件", "wordText.ftl");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/tesLocalCache")
    public void tesLocalCache() throws Exception {
        //list<Long> skuId
        //价格 优惠卷 限购 批量
        //Map<Long,SKUINFO>
        //泛型

        List<Long> skuIdList = new ArrayList<>();
        localCacheUtil.getResult(skuIdList, "skuInfo.skuName", SkuInfo.class, (list) -> {
            Map<Long, SkuInfo> skuInfoMap = getSkuName(skuIdList);
            return skuInfoMap;
        });

        localCacheUtil.getResult(skuIdList, "skuInfo.skuPrice", SkuInfo.class, (list) -> {
            Map<Long, SkuInfo> skuInfoMap = getSkuPrice(skuIdList);
            return skuInfoMap;
        });

    }

    public Map<Long, SkuInfo> getSkuName(List<Long> skuIds) {
        return Collections.emptyMap();
    }

    public Map<Long, SkuInfo> getSkuPrice(List<Long> skuIds) {
        return Collections.emptyMap();
    }

    class SkuInfo {
        private Long id;
        private String name;
        private Long price;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/testQuery")
    public void testQuery(@RequestBody SysUser sysUser) throws Exception {

        //2023-10-23 15:17:15
        System.out.println(sysUser);

    }

}
