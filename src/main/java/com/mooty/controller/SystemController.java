/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.controller;

import com.mooty.base.BaseController;
import com.mooty.service.RedisService;
import com.mooty.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mooty.redis.RedisCacheUtil;
import com.mooty.redis.RedisClientTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty.controller
 * @date 2017/2/28/028
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController{


    @Autowired(required = false)
    private SystemService systemService;

    @Autowired(required = false)
    private RedisService redisService;

    @Autowired(required = false)
    private RedisClientTemplate redisClientTemplate;

    @Autowired(required = false)
    private RedisCacheUtil<Object> cacheUtil;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String toIndex(){

        String testName = redisService.get("testName");

        System.out.println("============");
        System.out.println(testName);

        redisService.set("testName","loumingtao");

        System.out.println("============");
        System.out.println(redisService.get("testName"));

        redisService.del("testName");

        System.out.println("============");
        System.out.println(redisService.get("testName"));
        System.out.println("=======redisClientTemplate=====");
        redisClientTemplate.set("testName","loumt");
        System.out.println(redisClientTemplate.get("testName"));


        final Map<String,String> reMap = new HashMap<String, String>(){
            {
                put("name","loumt");
                put("age","18");
            }
        };
        System.out.println("=======cacheUtil============");
        cacheUtil.setCacheMap("reMap",reMap);
        System.out.println(cacheUtil.getCacheMap("reMap"));
        System.out.println("========cacheUtil===========");

        System.out.println("I screaming something to you , whatever something to me !!");

        return "/system/hello";
    }
}
