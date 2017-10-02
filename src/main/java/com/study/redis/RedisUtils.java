package com.study.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一些对redis常用的操作。
 * Created by Administrator on 2017/9/29.
 */
public class RedisUtils {

    private static JedisPool jedisPool = null;

    //创建redis的连接池
    static {
        InputStream in = RedisUtils.class.getResourceAsStream("/redis.properties");
        Properties p = new Properties();
        try {
            p.load(in);
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(Integer.parseInt(p.getProperty("redis.pool.maxIdle")));
            config.setMaxWaitMillis(Integer.parseInt(p.getProperty("redis.pool.maxWait")));
            config.setMaxTotal(Integer.parseInt(p.getProperty("redis.pool.maxActive")));
            String ip = p.getProperty("redis.ip");
            Integer port = Integer.parseInt(p.getProperty("redis.port"));

            jedisPool = new JedisPool(config, ip, port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取jedis 的值
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    //销毁连接
    public static void delJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
    //String 類型
    public static  String set(String key,String value){
        Jedis  jedis = null;
        String result = null;
        try {
            jedis = jedisPool.getResource();
            if(jedis.exists(key)){
                jedis.del(key);
                System.out.println("已經存在，將其刪除！");
            }
            result = jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        String s = RedisUtils.set("ttt", "xiaomi");
        if (s.equals("OK")){
            System.out.println("設置成功");
        }else {
            System.out.println("設置失敗");
        }
    }


}
