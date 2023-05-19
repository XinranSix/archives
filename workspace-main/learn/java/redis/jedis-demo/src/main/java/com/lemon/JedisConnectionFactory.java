package com.lemon;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(8);// 最大连接
        jedisPoolConfig.setMaxIdle(8);// 最大空闲连接
        jedisPoolConfig.setMinIdle(0); // 最小空闲连接
        jedisPoolConfig.setMaxWaitMillis(200); // 设置最长等待时间， ms

        jedisPool = new JedisPool(jedisPoolConfig, "192.168.17.134", 6379, 1000, "1234");   // 获取Jedis对象
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}

