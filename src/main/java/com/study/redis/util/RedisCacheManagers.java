package com.study.redis.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * redis 的配置进行管理
 * Created by Administrator on 2017/9/29.
 */
public class RedisCacheManagers {

  private static  String  redisdbtype;
  private static  String  redisdbnumber;

  private static String  host;
  private static String port;
  private static String timeout;
  private static String password;

  private static String maxtotal;
  private static String maxidle;
  private static String minidle;
  private static String maxwaitmillis;

  private static String testonborrow;
  private static String testwhileidle;


  public static JedisPoolConfig poolConfig;

  // 保存不同的数据库连接
 public static ConcurrentMap<String,RedisCachePool>  redisPoolMap = new ConcurrentHashMap<String, RedisCachePool>();

  static {
      ResourceLoader resource = new DefaultResourceLoader();
      Resource res = resource.getResource("redis.properties");
      InputStream in;
      try {

          //从配置文件将属性拿过来
          Properties p = new Properties();
          in = res.getInputStream();
          p.load(in);
          redisdbtype = p.getProperty("redisdbtype");
          redisdbnumber = p.getProperty("redisdbnumber");

          host = p.getProperty("host");
          port = p.getProperty("port");
          timeout = p.getProperty("timeout");
          password = p.getProperty("passwords");
          maxtotal = p.getProperty("maxtotal");
          maxidle = p.getProperty("maxidle");
          minidle = p.getProperty("minidle");
          maxwaitmillis = p.getProperty("maxwaitmillis");
          testonborrow = p.getProperty("testonborrow");
          testwhileidle = p.getProperty("testwhileidle");
      } catch (Exception e) {
          System.out.println("初始化化redis连接池失败！");
      }
  }
   public static ConcurrentMap<String,RedisCachePool>  getRedisPoolMap(){
          if (redisPoolMap.size() < 1){
              initConfig();
              initRedisPoolMap();
          }
          return redisPoolMap;
      }


    public static void  initConfig(){
        poolConfig = new JedisPoolConfig();
        poolConfig.setTestOnBorrow(testwhileidle.equals("true") ? true : false);
        poolConfig.setTestWhileIdle(testonborrow.equals("true") ? true : false);
        poolConfig.setMaxIdle(Integer.parseInt(maxidle));
        poolConfig.setMaxTotal(Integer.parseInt(maxtotal));
        poolConfig.setMinIdle(Integer.parseInt(minidle));
        poolConfig.setMaxWaitMillis(Integer.parseInt(maxwaitmillis));
    }

    public static void initRedisPoolMap(){
        try {
            if(redisdbtype != null && redisdbnumber != null){
                String[] dbs = redisdbtype.split(",");
                String[] numbers = redisdbnumber.split(",");
                for(int i = 0 ; i < dbs.length; i++){
                    JedisPool  jedisPool = new JedisPool(poolConfig,host,Integer.parseInt(port),Integer.parseInt(timeout),password);
                    redisPoolMap.put(dbs[i],new RedisCachePool(Integer.parseInt(numbers[i]),jedisPool));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
  }

  public static Jedis  getResource(RedisDataBaseType  dataBaseName){
        Jedis  jedisResource = null;
        RedisCachePool pool = redisPoolMap.get(dataBaseName.toString());
        if (pool != null){
            jedisResource = pool.getResource();
        }
      return  jedisResource;
  }

  public static void returnResource(RedisDataBaseType  dataBaseName,Jedis  jedis){
      RedisCachePool pool = redisPoolMap.get(dataBaseName);
      if(pool != null){
          pool.returnResource(jedis);
      }
  }
}
























