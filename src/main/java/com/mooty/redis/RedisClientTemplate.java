/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

/**
 * USED TO: 从ShardedJedisPool(适用于集群)中获取ShardedJedis
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package redis
 * @date 2017/2/28/028
 */
@Service
public class RedisClientTemplate {

    private static final Logger log = Logger.getLogger(RedisClientTemplate.class);

    @Autowired
    private RedisDataSource redisDataSource;

    public void disconnect() {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }

        boolean broken = false;
        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(shardedJedis, broken);
        }
        return result;
    }
}
