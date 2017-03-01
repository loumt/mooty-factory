/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package redis
 * @date 2017/2/28/028
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger logger = Logger.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;


    public ShardedJedis getRedisClient() {
        try {
            return shardedJedisPool.getResource();
        }catch (Exception e){
            logger.error("ShardedJedisPool getResource ERROR!!!!");
        }
        return null;
    }

    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
}
