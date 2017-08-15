/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.listener;

import org.springframework.data.redis.connection.jredis.JredisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package com.mooty
 * @date 2017/2/28/028
 */

public class SystemInitListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("系统正在初始化!");


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //TODO;
        System.out.println("这是切回2017.3.1后第一次提交");
    }
}
