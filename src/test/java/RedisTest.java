/**
 * Copyright (c) www.bugull.com
 */

import com.mooty.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/28/028
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-*.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests {


    @Autowired(required = false)
    private RedisService redisService;

    @Test
    public void redisTest(){
        String testName = redisService.get("testName");

        System.out.println("============");
        System.out.println(testName);

        redisService.set("testName","loumingtao");

        System.out.println("============");
        System.out.println(redisService.get("testName"));

        redisService.del("testName");

        System.out.println("============");
        System.out.println(redisService.get("testName"));
    }


}
