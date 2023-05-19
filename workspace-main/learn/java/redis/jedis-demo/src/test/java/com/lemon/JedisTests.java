package com.lemon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTests {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //jedis = new Jedis("192.168.17.134", 6379);
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("1234");
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "富哥");
        System.out.println(result);
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash() {
        jedis.hset("user:1", "name", "jack");
        jedis.hset("user:1", "age", "21");

        Map<String, String> map = jedis.hgetAll("user:1");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @AfterEach
    void tearDown() {
        if (null != jedis) {
            jedis.close();
        }
    }
}
