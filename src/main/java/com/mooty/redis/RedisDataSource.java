package com.mooty.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project mooty-factory
 * @package redis
 * @date 2017/2/28/028
 */
public interface RedisDataSource {
    /**
     * 取得redis的客户端
     * @return
     */
    ShardedJedis getRedisClient();

    /**
     * 将资源返还给pool
     * @param shardedJedis
     */
    void returnResource(ShardedJedis shardedJedis);

    /**
     * 出现异常后，将资源返还给pool
     * @param shardedJedis
     * @param broken
     */
    void returnResource(ShardedJedis shardedJedis,boolean broken);
}
