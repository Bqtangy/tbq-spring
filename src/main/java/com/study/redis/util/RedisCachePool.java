package com.study.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/9/29.
 */
public class RedisCachePool {
    private Integer db;
    private JedisPool jedisPool = null;

    public RedisCachePool(Integer db, JedisPool jedisPool) {
        this.db = db;
        this.jedisPool = jedisPool;
    }

    public Jedis getResource() {
        Jedis jedisInstance = null;
        if (jedisPool != null) {
            jedisInstance = jedisPool.getResource();
            if (db > 0) {//一般默认0数据库查询
                jedisInstance.select(db);
            }
        }
        return jedisInstance;
    }

    public void returnResource(final Jedis jedis){
        if (jedis != null){
            jedisPool.returnResource(jedis);
        }
    }

}
