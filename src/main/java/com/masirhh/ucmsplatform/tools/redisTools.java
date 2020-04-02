package com.masirhh.ucmsplatform.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class redisTools {
    static JedisPool jedisPool = new JedisPool();


    public static String redisGet(String key) {
        Jedis redis = jedisPool.getResource();
        String s = redis.get(key);
        redis.close();
        return s;
    }

    public static void redisSet(String key, String value) {
        Jedis redis = jedisPool.getResource();
        redis.set(key, value);
        redis.expire(key, 60 * 30);
        redis.close();
    }

}
